package com.jumbotail.shipping.model;

public class Warehouse {

    private int warehouseId;
    private String name;
    private Location warehouseLocation;

    public Warehouse() {}

    public Warehouse(int warehouseId, String name, Location warehouseLocation) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.warehouseLocation = warehouseLocation;
    }

    public int getWarehouseId() { return warehouseId; }
    public void setWarehouseId(int warehouseId) { this.warehouseId = warehouseId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Location getWarehouseLocation() { return warehouseLocation; }
    public void setWarehouseLocation(Location warehouseLocation) {
        this.warehouseLocation = warehouseLocation;
    }
}