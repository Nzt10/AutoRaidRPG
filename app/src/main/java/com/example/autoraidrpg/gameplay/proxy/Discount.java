package com.example.autoraidrpg.gameplay.proxy;

public interface Discount {

    public default double discount(double whole, double rate) {
        return whole + (whole * rate / 100);
    }

    public default double discountRate(double whole, double rate) {
        return whole + rate;
    }

    public default double actualDiscount(double whole, double rate) {
        return whole * rate / 100;
    }
    
}
