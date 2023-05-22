package com.example.autoraidrpg.model;

import java.io.Serializable;

public class Position implements Serializable {

    private int id;
    private int roleCollectionID;
    private int index;
    private boolean front;

    public Position() {}

    public Position(int id, int roleCollectionID, int index, boolean front) {
        this.id = id;
        this.roleCollectionID = roleCollectionID;
        this.index = index;
        this.front = front;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleCollectionID() {
        return roleCollectionID;
    }

    public void setRoleCollectionID(int roleCollectionID) {
        this.roleCollectionID = roleCollectionID;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isFront() {
        return front;
    }

    public void setFront(boolean front) {
        this.front = front;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", roleCollectionID=" + roleCollectionID +
                ", index=" + index +
                ", front=" + front +
                '}';
    }

}
