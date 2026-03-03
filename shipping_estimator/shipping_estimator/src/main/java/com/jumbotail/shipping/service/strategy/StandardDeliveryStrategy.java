package com.jumbotail.shipping.service.strategy;

import org.springframework.stereotype.Component;

@Component("STANDARD")
public class StandardDeliveryStrategy implements DeliveryStrategy {

    @Override
    public double applyCharge(double baseCharge) {
        return baseCharge; // no extra
    }
}