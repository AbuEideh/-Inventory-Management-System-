package com.bzu.inventorymanagementsystemAPIs.Models;

import jakarta.persistence.*;

/**
 * Inventory class represents the inventory for products in the IMS
 * It holds information about inventory like product, quantity, last restock date and location
 */

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;
    private int quantity;
    private String lastRestockDate;
    private String location;

    /**
     * Default constructor
     */
    public Inventory() {
    }

    /**
     * Parameterized constructor for the class
     * @param id
     * @param product
     * @param quantity
     * @param lastRestockDate
     * @param location
     */
    public Inventory(int id, Product product, int quantity, String lastRestockDate, String location) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.lastRestockDate = lastRestockDate;
        this.location = location;
    }

    /**
     * Getters & Setters to retrieve and set the attributes of inventory
     *
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        return "Inventory{" +
                "id=" + id +
                ", product=" + product +
                ", quantity='" + quantity + '\'' +
                ", lastRestockDate=" + lastRestockDate +
                ", location='" + location + '\'' +
                '}';
    }
}
