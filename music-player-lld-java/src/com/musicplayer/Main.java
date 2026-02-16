package com.musicplayer;

import com.musicplayer.audio.AudioEngine;
import com.musicplayer.model.NormalPlaylist;
import com.musicplayer.model.Song;
import com.musicplayer.player.MusicPlayer;
import com.musicplayer.strategy.RandomStrategy;

public class Main {

    public static void main(String[] args) {

        Song s1 = new Song("1", "Song A", 200, "/path/a");
        Song s2 = new Song("2", "Song B", 180, "/path/b");
        Song s3 = new Song("3", "Song C", 220, "/path/c");

        NormalPlaylist playlist = new NormalPlaylist("My Playlist");
        playlist.addSong(s1);
        playlist.addSong(s2);
        playlist.addSong(s3);

        AudioEngine audioEngine = new AudioEngine();
        MusicPlayer player = new MusicPlayer(audioEngine);

        player.setPlaylist(playlist, new RandomStrategy());
        player.play();
    }
}
