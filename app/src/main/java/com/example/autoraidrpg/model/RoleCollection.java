package com.example.autoraidrpg.model;

import java.io.Serializable;

public class RoleCollection implements Serializable {

    private int id;
    private int userID;
    private int roleID;
    private int level;
    private int rating;
    private int skillA;
    private int skillB;
    private int skillC;
    private int skillD;
    private int skillE;

    public RoleCollection(int id, int userID, int roleID, int level, int rating, int skillA, int skillB, int skillC, int skillD, int skillE) {
        this.id = id;
        this.userID = userID;
        this.roleID = roleID;
        this.level = level;
        this.rating = rating;
        this.skillA = skillA;
        this.skillB = skillB;
        this.skillC = skillC;
        this.skillD = skillD;
        this.skillE = skillE;
    }

    public void levelUp() { level++; }

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

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSkillA() {
        return skillA;
    }

    public void setSkillA(int skillA) {
        this.skillA = skillA;
    }

    public int getSkillB() {
        return skillB;
    }

    public void setSkillB(int skillB) {
        this.skillB = skillB;
    }

    public int getSkillC() {
        return skillC;
    }

    public void setSkillC(int skillC) {
        this.skillC = skillC;
    }

    public int getSkillD() {
        return skillD;
    }

    public void setSkillD(int skillD) {
        this.skillD = skillD;
    }

    public int getSkillE() {
        return skillE;
    }

    public void setSkillE(int skillE) {
        this.skillE = skillE;
    }

    @Override
    public String toString() {
        return "RoleCollection{" +
                "id=" + id +
                ", userID=" + userID +
                ", roleID=" + roleID +
                ", level=" + level +
                ", rating=" + rating +
                ", skillA=" + skillA +
                ", skillB=" + skillB +
                ", skillC=" + skillC +
                ", skillD=" + skillD +
                ", skillE=" + skillE +
                '}';
    }
}
