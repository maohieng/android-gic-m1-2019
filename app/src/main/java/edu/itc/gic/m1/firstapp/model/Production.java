package edu.itc.gic.m1.firstapp.model;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 1/29/2020
 */
public class Production {

    String logo;
    String name;

    /**
     * Default constructor - for any mapping lib
     */
    public Production(){}

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
