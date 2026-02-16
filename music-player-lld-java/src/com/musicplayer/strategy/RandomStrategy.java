package com.musicplayer.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomStrategy implements PlaybackStrategy {

    private List<Integer> shuffledOrder;
    private int pointer;

    @Override
    public void initialize(int size) {
        shuffledOrder = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            shuffledOrder.add(i);
        }
        Collections.shuffle(shuffledOrder);
        pointer = 0;
    }

    @Override
    public int next(int currentIndex) {
        pointer++;
        if (pointer >= shuffledOrder.size()) {
            return -1;
        }
        return shuffledOrder.get(pointer);
    }

    @Override
    public void onSongRemoved(int removedIndex) {
        shuffledOrder.remove(Integer.valueOf(removedIndex));

        for (int i = 0; i < shuffledOrder.size(); i++) {
            if (shuffledOrder.get(i) > removedIndex) {
                shuffledOrder.set(i, shuffledOrder.get(i) - 1);
            }
        }
    }

    @Override
    public void onSongAdded(int newIndex) {
        int insertPosition = (int) (Math.random() * (shuffledOrder.size() + 1));
        shuffledOrder.add(insertPosition, newIndex);
    }
}
