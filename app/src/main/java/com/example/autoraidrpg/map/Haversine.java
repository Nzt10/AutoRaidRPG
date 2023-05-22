package com.example.autoraidrpg.map;

public class Haversine {
    public static final double RADIUS_OF_EARTH_KM = 6371;
    private double lat1, lon1, lat2, lon2;

    public Haversine getLatLong1(double lat1, double lon1) {
        this.lat1 = lat1;
        this.lon1 = lon1;
        return this;
    }

    public Haversine getLatLong2(double lat2, double lon2) {
        this.lat2 = lat2;
        this.lon2 = lon2;
        return this;
    }

    public double getDistance() {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return RADIUS_OF_EARTH_KM * c;
    }

}
