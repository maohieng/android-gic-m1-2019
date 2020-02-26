package edu.itc.gic.m1.firstapp.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Entity(tableName = "singers")
public class Singer {

    @PrimaryKey
    long id;

    String name;
    String photo;

    public Singer() {
    }

    @Ignore
    public Singer(String name, String photo) {
        this.name = name;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
