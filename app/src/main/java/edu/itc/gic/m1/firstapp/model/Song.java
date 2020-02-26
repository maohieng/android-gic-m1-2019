package edu.itc.gic.m1.firstapp.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Entity(tableName = "songs")
public class Song {

    @PrimaryKey
    long id;

    String title;

    @ColumnInfo(name = "audio_url")
    String audioUrl;


    public Song() {}

    @Ignore
    public Song(String title, String audioUrl) {
        this.title = title;
        this.audioUrl = audioUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
