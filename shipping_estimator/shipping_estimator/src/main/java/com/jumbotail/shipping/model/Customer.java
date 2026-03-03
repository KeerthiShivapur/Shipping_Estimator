package com.jumbotail.shipping.model;

public class Customer {

    private int customerId;
    private Location location;

    public Customer(int customerId, Location location) {
        this.customerId = customerId;
        this.location = location;
    }

    public int getCustomerId() { return customerId; }
    public Location getLocation() { return location; }
}