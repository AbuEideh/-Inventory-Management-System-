package com.bzu.inventorymanagementsystemAPIs.DTOs;

import com.bzu.inventorymanagementsystemAPIs.Models.OrderStatus;

import java.util.List;

public class OrderRequestDTO {
    private int id;
    private int supplierId;
    private List<Integer> productIds;
    private int quantity;
    private String orderDate;
    private String deliveryDate;
    private OrderStatus orderStatus;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(int id, int supplierId, List<Integer> productIds, int quantity, String orderDate, String deliveryDate, OrderStatus orderStatus) {
        this.id = id;
        this.supplierId = supplierId;
        this.productIds = productIds;
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

    public List<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Integer> productIds) {
        this.productIds = productIds;
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
