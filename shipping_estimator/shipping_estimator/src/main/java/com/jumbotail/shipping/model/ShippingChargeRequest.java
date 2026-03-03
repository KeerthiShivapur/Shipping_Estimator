package com.jumbotail.shipping.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ShippingChargeRequest {

    @NotNull(message = "Seller ID is required")
    private Integer sellerId;

    @NotNull(message = "Customer ID is required")
    private Integer customerId;

    @NotBlank(message = "Delivery speed is required")
    private String deliverySpeed;

    // Default Constructor
    public ShippingChargeRequest() {}

    // Parameterized Constructor
    public ShippingChargeRequest(Integer sellerId,
                                 Integer customerId,
                                 String deliverySpeed) {
        this.sellerId = sellerId;
        this.customerId = customerId;
        this.deliverySpeed = deliverySpeed;
    }

    // Getters and Setters
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDeliverySpeed() {
        return deliverySpeed;
    }

    public void setDeliverySpeed(String deliverySpeed) {
        this.deliverySpeed = deliverySpeed;
    }
}