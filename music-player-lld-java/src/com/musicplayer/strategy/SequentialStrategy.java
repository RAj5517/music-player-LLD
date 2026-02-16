package com.musicplayer.strategy;

public class SequentialStrategy implements PlaybackStrategy {

    private int size;

    @Override
    public void initialize(int size) {
        this.size = size;
    }

    @Override
    public int next(int currentIndex) {
        if (currentIndex + 1 >= size) {
            return -1; // end reached
        }
        return currentIndex + 1;
    }

    @Override
    public void onSongRemoved(int removedIndex) {
        size--;
    }

    @Override
    public void onSongAdded(int newIndex) {
        size++;
    }
}
