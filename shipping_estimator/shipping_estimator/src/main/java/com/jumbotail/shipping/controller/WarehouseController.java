package com.jumbotail.shipping.controller;

import com.jumbotail.shipping.model.*;
import com.jumbotail.shipping.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/warehouse")
public class WarehouseController {

    private final WarehouseService warehouseService;

    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping("/nearest")
    public Warehouse getNearestWarehouse(@RequestParam double lat,
                                         @RequestParam double lon) {

        Location sellerLocation = new Location(lat, lon);
        return warehouseService.getNearestWarehouse(sellerLocation);
    }
}