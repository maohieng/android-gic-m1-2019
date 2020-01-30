package edu.itc.gic.m1.firstapp.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
@Entity(tableName = "productions")
public class Production {

    @PrimaryKey
    long id;

    @ColumnInfo(name = "logo_url")
    String logo;
    String name;

    /**
     * Default constructor - for any mapping lib
     */
    public Production() {
    }

    public Production(String name) {
        this.name = name;
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
}
