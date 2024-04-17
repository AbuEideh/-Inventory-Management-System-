package com.bzu.inventorymanagementsystemAPIs.Models;
import jakarta.persistence.*;
import java.util.List;

/**
 * The order class represents an order in the IMS
 * It hold information about the order
 */
@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "OrderID")
    private int id;
    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private Supplier supplier;
    @ManyToMany
    @JoinTable(
            name = "product_order",
            joinColumns = @JoinColumn(name = "OrderID"),
            inverseJoinColumns = @JoinColumn(name = "ProductID")
    )
    private List<Product> products;
    @Column (name = "Quantity")
    private int quantity;

    private String orderDate;

    private String deliveryDate;

    private OrderStatus orderStatus;

    /**
     * Default constructor
     */
    public Order() {
    }

    /**
     * Parameterized constructor
     * @param id
     * @param supplier
     * @param products
     * @param quantity
     * @param orderDate
     * @param deliveryDate
     * @param orderStatus
     */
    public Order(int id, Supplier supplier, List<Product> products, int quantity, String orderDate, String deliveryDate, OrderStatus orderStatus) {
        this.id = id;
        this.supplier = supplier;
        this.products = products;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
    }

    /**
     * Getters & Setters for order attributes
     *
     */
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", supplier=" + supplier +
                ", product=" + products +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
