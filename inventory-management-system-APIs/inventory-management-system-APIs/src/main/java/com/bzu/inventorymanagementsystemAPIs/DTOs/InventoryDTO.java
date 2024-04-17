package com.bzu.inventorymanagementsystemAPIs.DTOs;

public class InventoryDTO {
    private int id;
    private int productId;
    private int quantity;
    private String lastRestockDate;
    private String location;

    public InventoryDTO() {
    }

    public InventoryDTO(int id, int productId, int quantity, String lastRestockDate, String location) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.lastRestockDate = lastRestockDate;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getLastRestockDate() {
        return lastRestockDate;
    }

    public void setLastRestockDate(String lastRestockDate) {
        this.lastRestockDate = lastRestockDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "InventoryDTO{" +
                "id=" + id +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", lastRestockDate='" + lastRestockDate + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
