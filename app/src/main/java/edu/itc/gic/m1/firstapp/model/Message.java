package edu.itc.gic.m1.firstapp.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is used for ...
 *
 * @autor MAO Hieng 12/25/2019
 */
public class Message implements Serializable {

    // Required field
    final String message;

    // Optional fields
    long ownerId;

    String ownerName;

    String ownerImage;

    Date createdDate;

    Date modifiedDate;

    public Message(String message) {
        this.message = message;
        createdDate = modifiedDate = new Date();
    }

    public String getMessage() {
        return message;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerImage() {
        return ownerImage;
    }

    public void setOwnerImage(String ownerImage) {
        this.ownerImage = ownerImage;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
