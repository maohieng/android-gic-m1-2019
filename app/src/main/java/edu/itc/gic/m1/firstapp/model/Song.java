package edu.itc.gic.m1.firstapp.model;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
public class Song {

    String title;
    String audioUrl;

    public Song() {}

    public Song(String title, String audioUrl) {
        this.title = title;
        this.audioUrl = audioUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public void setAudioUrl(String audioUrl) {
        this.audioUrl = audioUrl;
    }
}
