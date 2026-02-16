package com.musicplayer.model;

public class Song {

    private final String id;
    private final String title;
    private final int duration; // seconds
    private final String filePath;

    public Song(String id, String title, int duration, String filePath) {
        this.id = id;
        this.title = title;
        this.duration = duration;
        this.filePath = filePath;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getFilePath() {
        return filePath;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
