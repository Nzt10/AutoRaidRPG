package com.example.autoraidrpg.model;

import java.io.Serializable;

public class Formation implements Serializable {

    private int id;
    private int userID;
    private int positionID_A;
    private int positionID_B;
    private int positionID_C;
    private int positionID_D;
    private int positionID_E;

    public Formation(int id, int userID, int positionID_A, int positionID_B, int positionID_C, int positionID_D, int positionID_E) {
        this.id = id;
        this.userID = userID;
        this.positionID_A = positionID_A;
        this.positionID_B = positionID_B;
        this.positionID_C = positionID_C;
        this.positionID_D = positionID_D;
        this.positionID_E = positionID_E;
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

    public int getPositionID_A() {
        return positionID_A;
    }

    public void setPositionID_A(int positionID_A) {
        this.positionID_A = positionID_A;
    }

    public int getPositionID_B() {
        return positionID_B;
    }

    public void setPositionID_B(int positionID_B) {
        this.positionID_B = positionID_B;
    }

    public int getPositionID_C() {
        return positionID_C;
    }

    public void setPositionID_C(int positionID_C) {
        this.positionID_C = positionID_C;
    }

    public int getPositionID_D() {
        return positionID_D;
    }

    public void setPositionID_D(int positionID_D) {
        this.positionID_D = positionID_D;
    }

    public int getPositionID_E() {
        return positionID_E;
    }

    public void setPositionID_E(int positionID_E) {
        this.positionID_E = positionID_E;
    }

    @Override
    public String toString() {
        return "Formation{" +
                "id=" + id +
                ", userID=" + userID +
                ", positionID_A=" + positionID_A +
                ", positionID_B=" + positionID_B +
                ", positionID_C=" + positionID_C +
                ", positionID_D=" + positionID_D +
                ", positionID_E=" + positionID_E +
                '}';
    }

}
