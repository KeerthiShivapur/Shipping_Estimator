package com.jumbotail.shipping.service;

import com.jumbotail.shipping.model.Location;
import com.jumbotail.shipping.model.Warehouse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WarehouseService {

    private final DistanceCalculator distanceCalculator;

    public WarehouseService(DistanceCalculator distanceCalculator) {
        this.distanceCalculator = distanceCalculator;
    }

    private final List<Warehouse> warehouses = Arrays.asList(
            new Warehouse(1, "BLR_Warehouse",
                    new Location(12.9716, 77.5946)),
            new Warehouse(2, "MUM_Warehouse",
                    new Location(19.0760, 72.8777))
    );

    // ✅ ADD CACHE HERE
    @Cacheable("nearestWarehouse")
    public Warehouse getNearestWarehouse(Location sellerLocation) {

        System.out.println("Calculating nearest warehouse..."); // Debug to see cache working

        Warehouse nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Warehouse w : warehouses) {

            double distance =
                    distanceCalculator.calculateDistance(
                            sellerLocation.getLat(),
                            sellerLocation.getLon(),
                            w.getWarehouseLocation().getLat(),
                            w.getWarehouseLocation().getLon());

            if (distance < minDistance) {
                minDistance = distance;
                nearest = w;
            }
        }

        return nearest;
    }
}