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
@Entity(tableName = "productions")
public class Production {

    @PrimaryKey(autoGenerate = true)
    long id;

    @ColumnInfo(name = "logo_url")
    String logo;

    String name;

    /**
     * Default constructor - ROOM
     */
    public Production() {
    }

    @Ignore
    public Production(String name, String logoUrl) {
        this.name = name;
        this.logo = logoUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
