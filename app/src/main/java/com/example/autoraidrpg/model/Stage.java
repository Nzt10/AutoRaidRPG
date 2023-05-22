package com.example.autoraidrpg.model;

import java.io.Serializable;

public class Stage implements Serializable {

    private int userID;
    private int value;

    public Stage(int userID, int value) {
        this.userID = userID;
        this.value = value;
    }


    public void increment() { value++; }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
