package com.bzu.inventorymanagementsystemAPIs.Models;
import jakarta.persistence.*;

/**
 * This class represent an association between order
 * and product in the IMS
 */
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Product product;


    @ManyToOne
    @JoinColumn(name = "OrderID")
    private Order order;


    /**
     * Default constructor
     */
    public ProductOrder() {
    }

    /**
     * Parameterized constructor
     * @param id
     * @param product
     * @param order
     */
    public ProductOrder(int id,Product product, Order order) {
        this.id = id;
        this.product = product;
        this.order = order;
    }

    /**
     *Getters & Setters for class attributes
     */
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "ProductOrder{" +
                "id=" + id +
                ", product=" + product +
                ", order=" + order +
                '}';
    }
}
