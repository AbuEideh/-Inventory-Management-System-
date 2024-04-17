package com.bzu.inventorymanagementsystemAPIs.DTOs;

import com.bzu.inventorymanagementsystemAPIs.Models.OrderStatus;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;

import java.util.List;

public class OrderResponseDTO {
    private int id;
    private int supplierId;
    private List<Product> products;
    private int quantity;
    private String orderDate;
    private String deliveryDate;
    private OrderStatus orderStatus;

    public OrderResponseDTO() {
    }

    public OrderResponseDTO(int id, int supplierId, List<Product> products, int quantity, String orderDate, String deliveryDate, OrderStatus orderStatus) {
        this.id = id;
        this.supplierId = supplierId;
        this.products = products;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
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
}
