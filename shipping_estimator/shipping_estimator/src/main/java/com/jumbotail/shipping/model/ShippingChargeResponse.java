package com.jumbotail.shipping.model;

public class ShippingChargeResponse {

    private double shippingCharge;
    private Warehouse nearestWarehouse;
    private double distanceInKm;
    private String deliveryType;
    private String transportMode;

    // Default Constructor
    public ShippingChargeResponse() {
    }

    // All Arguments Constructor
    public ShippingChargeResponse(double shippingCharge,
                                  Warehouse nearestWarehouse,
                                  double distanceInKm,
                                  String deliveryType,
                                  String transportMode) {
        this.shippingCharge = shippingCharge;
        this.nearestWarehouse = nearestWarehouse;
        this.distanceInKm = distanceInKm;
        this.deliveryType = deliveryType;
        this.transportMode = transportMode;
    }

    // Getters and Setters

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    public Warehouse getNearestWarehouse() {
        return nearestWarehouse;
    }

    public void setNearestWarehouse(Warehouse nearestWarehouse) {
        this.nearestWarehouse = nearestWarehouse;
    }

    public double getDistanceInKm() {
        return distanceInKm;
    }

    public void setDistanceInKm(double distanceInKm) {
        this.distanceInKm = distanceInKm;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getTransportMode() {
        return transportMode;
    }

    public void setTransportMode(String transportMode) {
        this.transportMode = transportMode;
    }
}