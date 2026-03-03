package com.jumbotail.shipping.service.strategy;

import org.springframework.stereotype.Component;

@Component("EXPRESS")
public class ExpressDeliveryStrategy implements DeliveryStrategy {

    @Override
    public double applyCharge(double baseCharge) {
        return baseCharge * 1.2; // 20% extra
    }
}