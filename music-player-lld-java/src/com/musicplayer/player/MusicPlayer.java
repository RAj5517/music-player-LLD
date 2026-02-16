package com.musicplayer.player;

import com.musicplayer.audio.AudioEngine;
import com.musicplayer.audio.PlaybackListener;
import com.musicplayer.model.Playlist;
import com.musicplayer.model.Song;
import com.musicplayer.strategy.PlaybackStrategy;

public class MusicPlayer implements PlaybackListener {

    private Playlist currentPlaylist;
    private Song currentSong;
    private int currentIndex;
    private PlaybackState state = PlaybackState.STOPPED;
    private PlaybackMode mode = PlaybackMode.SINGLE;
    private RepeatMode repeatMode = RepeatMode.NONE;

    private PlaybackStrategy strategy;
    private final AudioEngine audioEngine;

    public MusicPlayer(AudioEngine audioEngine) {
        this.audioEngine = audioEngine;
        this.audioEngine.setPlaybackListener(this);
    }

    public void setPlaylist(Playlist playlist, PlaybackStrategy strategy) {
        this.currentPlaylist = playlist;
        this.strategy = strategy;
        this.mode = PlaybackMode.PLAYLIST;
        this.currentIndex = 0;
        this.strategy.initialize(playlist.getSongs().size());
    }

    public void playSong(Song song) {
        this.currentSong = song;
        this.mode = PlaybackMode.SINGLE;
        audioEngine.play(song);
        state = PlaybackState.PLAYING;
    }

    public void play() {
        if (mode == PlaybackMode.PLAYLIST && currentPlaylist != null) {
            currentSong = currentPlaylist.getSongs().get(currentIndex);
            audioEngine.play(currentSong);
            state = PlaybackState.PLAYING;
        }
    }

    public void pause() {
        audioEngine.pause();
        state = PlaybackState.PAUSED;
    }

    public void next() {
        if (mode == PlaybackMode.PLAYLIST && strategy != null) {
            int nextIndex = strategy.next(currentIndex);
            if (nextIndex == -1) {
                handleRepeat();
                return;
            }
            currentIndex = nextIndex;
            currentSong = currentPlaylist.getSongs().get(currentIndex);
            audioEngine.play(currentSong);
        }
    }

    private void handleRepeat() {
        switch (repeatMode) {
            case REPEAT_ONE:
                audioEngine.play(currentSong);
                break;
            case REPEAT_ALL:
                currentIndex = 0;
                audioEngine.play(currentPlaylist.getSongs().get(currentIndex));
                break;
            case NONE:
                audioEngine.stop();
                state = PlaybackState.STOPPED;
                break;
        }
    }

    @Override
    public void onPlaybackComplete() {
        next();
    }
}
