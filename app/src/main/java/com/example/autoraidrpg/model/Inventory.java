package com.example.autoraidrpg.model;

import java.io.Serializable;

public class Inventory implements Serializable {

    private int id;
    private int userID;
    private int itemID;
    private int rating;

    public Inventory(int id, int userID, int itemID, int rating) {
        this.id = id;
        this.userID = userID;
        this.itemID = itemID;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", userID=" + userID +
                ", itemID=" + itemID +
                ", rating=" + rating +
                '}';
    }
}
