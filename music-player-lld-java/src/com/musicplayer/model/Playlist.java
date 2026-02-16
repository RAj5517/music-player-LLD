package com.musicplayer.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Playlist {

    protected final String name;
    protected final List<Song> songs;

    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(Song song) {
        songs.remove(song);
    }

    public List<Song> getSongs() {
        return Collections.unmodifiableList(songs);
    }

    public String getName() {
        return name;
    }
}
