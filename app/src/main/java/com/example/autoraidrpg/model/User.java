package com.example.autoraidrpg.model;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String username;
    private String email;
    private String password;
    private double longitude;
    private double latitude;
    private double coin;

    private double exp;
    private double diamond;

    public User(int id, String username, String email, String password, double longitude, double latitude, double coin, double exp, double diamond) {
        this.username = username;
        this.id = id;
        this.email = email;
        this.password = password;
        this.longitude = longitude;
        this.latitude = latitude;
        this.coin = coin;
        this.exp = exp;
        this.diamond = diamond;
    }

    public void addGold(double gold) {
        this.coin += gold;
    }

    public void addExp(double exp) {
        this.exp += exp;
    }

    public void addDiamond(double diamond) {
        this.diamond += diamond;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public double getLongitude() {
        return longitude;
    }
    public double getLatitude() {
        return latitude;
    }

    public double getCoin() {
        return coin;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setCoin(double coin) {
        this.coin = coin;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public double getDiamond() {
        return diamond;
    }

    public void setDiamond(double diamond) {
        this.diamond = diamond;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", gold=" + coin +
                ", exp=" + exp +
                ", diamond=" + diamond +
                '}';
    }
}
