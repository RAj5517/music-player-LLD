package com.musicplayer.audio;

import com.musicplayer.model.Song;

public class AudioEngine {

    private PlaybackListener listener;

    public void setPlaybackListener(PlaybackListener listener) {
        this.listener = listener;
    }

    public void play(Song song) {
        System.out.println("Playing: " + song.getTitle());
    }

    public void pause() {
        System.out.println("Paused");
    }

    public void stop() {
        System.out.println("Stopped");
    }

    // simulate song finish
    public void simulateSongEnd() {
        if (listener != null) {
            listener.onPlaybackComplete();
        }
    }
}
