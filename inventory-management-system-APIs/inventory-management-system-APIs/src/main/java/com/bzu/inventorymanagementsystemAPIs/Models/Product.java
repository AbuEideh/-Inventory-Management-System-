package com.bzu.inventorymanagementsystemAPIs.Models;

import jakarta.persistence.*;

/**
 * This class represents product in the IMS
 * It holds information about a product
 */
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private double price;

    private int quantityAvailable;
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * Parameterized constructor
     * @param id
     * @param name
     * @param description
     * @param price
     * @param quantityAvailable
     * @param supplier
     */
    public Product(int id, String name, String description, double price, int quantityAvailable, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantityAvailable = quantityAvailable;
        this.supplier = supplier;
    }

    /**
     * Getters & Setter to set and retrieve
     * class attributes
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity_available() {
        return quantityAvailable;
    }

    public void setQuantity_available(int quantity_available) {
        this.quantityAvailable = quantity_available;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity_available=" + quantityAvailable +
                ", supplier=" + supplier +
                '}';
    }
}
