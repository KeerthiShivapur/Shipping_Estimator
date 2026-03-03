package com.jumbotail.shipping.service.strategy;

public interface DeliveryStrategy {
    double applyCharge(double baseCharge);
}