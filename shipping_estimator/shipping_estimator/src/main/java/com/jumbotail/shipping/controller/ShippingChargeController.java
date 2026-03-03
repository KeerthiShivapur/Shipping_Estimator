package com.jumbotail.shipping.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import com.jumbotail.shipping.model.*;
import com.jumbotail.shipping.service.*;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/shipping-charge")
public class ShippingChargeController {

    private final DataService dataService;
    private final WarehouseService warehouseService;
    private final ShippingService shippingService;
    private final DistanceCalculator distanceCalculator;

    public ShippingChargeController(DataService dataService,
                                    WarehouseService warehouseService,
                                    ShippingService shippingService,
                                    DistanceCalculator distanceCalculator) {

        this.dataService = dataService;
        this.warehouseService = warehouseService;
        this.shippingService = shippingService;
        this.distanceCalculator = distanceCalculator;
    }

    @Operation(
            summary = "Calculate shipping charge",
            description = "Calculates shipping cost based on seller, customer and delivery speed"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully calculated"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    @PostMapping("/calculate")
    public ShippingChargeResponse calculateShipping(
            @Valid @RequestBody ShippingChargeRequest request) {

        // Fetch seller & customer
        Seller seller = dataService.getSellerById(request.getSellerId());
        Customer customer = dataService.getCustomerById(request.getCustomerId());

        // Find nearest warehouse
        Warehouse nearest =
                warehouseService.getNearestWarehouse(seller.getLocation());

        // Calculate distance (Warehouse -> Customer)
        double distance =
                distanceCalculator.calculateDistance(
                        nearest.getWarehouseLocation().getLat(),
                        nearest.getWarehouseLocation().getLon(),
                        customer.getLocation().getLat(),
                        customer.getLocation().getLon());

        double weight = 10; // fixed weight for now

        // Calculate charge using strategy
        double charge =
                shippingService.calculateShippingCharge(
                        distance,
                        weight,
                        request.getDeliverySpeed());

        String transportMode =
                shippingService.determineTransportMode(distance);

        double roundedDistance = Math.round(distance * 100.0) / 100.0;
        double roundedCharge = Math.round(charge * 100.0) / 100.0;

        return new ShippingChargeResponse(
                roundedCharge,
                nearest,
                roundedDistance,
                request.getDeliverySpeed(),
                transportMode
        );
    }
}