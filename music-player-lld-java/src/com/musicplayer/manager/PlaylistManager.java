package com.musicplayer.manager;

import com.musicplayer.model.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistManager {

    private final List<Playlist> playlists = new ArrayList<>();

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void removePlaylist(Playlist playlist) {
        playlists.remove(playlist);
    }

    public List<Playlist> getAllPlaylists() {
        return playlists;
    }
}
