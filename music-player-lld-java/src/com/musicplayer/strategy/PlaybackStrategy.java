package com.musicplayer.strategy;

import java.util.List;

public interface PlaybackStrategy {

    void initialize(int size);

    int next(int currentIndex);

    void onSongRemoved(int removedIndex);

    void onSongAdded(int newIndex);
}
