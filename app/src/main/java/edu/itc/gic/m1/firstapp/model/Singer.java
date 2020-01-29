package edu.itc.gic.m1.firstapp.model;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
public class Singer {

    String name;
    String photo;

    public Singer() {}

    public Singer(String name, String photo) {
        this.name = name;
        this.photo = photo;
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
}
