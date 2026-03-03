package com.jumbotail.shipping.service;

import com.jumbotail.shipping.service.strategy.DeliveryStrategy;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShippingService {

    private final Map<String, DeliveryStrategy> strategyMap;

    public ShippingService(Map<String, DeliveryStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public double calculateShippingCharge(double distance,
                                          double weight,
                                          String deliverySpeed) {

        double rate;

        // Determine rate based on transport logic
        if (distance >= 500) {
            rate = 1;      // Aeroplane
        } else if (distance >= 100) {
            rate = 2;      // Truck
        } else {
            rate = 3;      // Mini Van
        }

        // Base calculation
        double baseCharge = (distance * weight * rate) + 10;

        // Apply delivery strategy (Standard / Express)
        DeliveryStrategy strategy =
                strategyMap.getOrDefault(
                        deliverySpeed.toUpperCase(),
                        strategyMap.get("STANDARD")
                );

        return strategy.applyCharge(baseCharge);
    }

    // Transport mode logic for response
    public String determineTransportMode(double distance) {
        if (distance >= 500) {
            return "AEROPLANE";
        } else if (distance >= 100) {
            return "TRUCK";
        } else {
            return "MINI_VAN";
        }
    }
}