package com.musicplayer.model;

import java.util.HashSet;
import java.util.Set;

public class CollaborativePlaylist extends Playlist {

    private final Set<String> collaborators;

    public CollaborativePlaylist(String name) {
        super(name);
        this.collaborators = new HashSet<>();
    }

    public void addCollaborator(String userId) {
        collaborators.add(userId);
    }

    public boolean isCollaborator(String userId) {
        return collaborators.contains(userId);
    }
}
