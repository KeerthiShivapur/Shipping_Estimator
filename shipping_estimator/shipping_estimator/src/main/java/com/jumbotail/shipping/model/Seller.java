package com.jumbotail.shipping.model;

public class Seller {

    private int sellerId;
    private Location location;

    public Seller(int sellerId, Location location) {
        this.sellerId = sellerId;
        this.location = location;
    }

    public int getSellerId() { return sellerId; }
    public Location getLocation() { return location; }
}