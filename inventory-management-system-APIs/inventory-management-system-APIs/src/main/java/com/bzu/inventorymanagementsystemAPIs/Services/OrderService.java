package com.bzu.inventorymanagementsystemAPIs.Services;

import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderRequestDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderResponseDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Order;

import java.util.List;

/**
 * This interface defines operations for managing order data
 */
public interface OrderService {
    /**
     * To create a new order
     * @param orderRequestDTO order data to be created
     * @return the created order DTO
     */
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);

    /**
     * To retrieve all orders
     * @return the list of all orders DTO
     */
    List<OrderResponseDTO> getAllOrders();

    /**
     * To replace all existing orders with the provided orders list
     * @param ordersDtos the list of order DTOs to replace the existing ones.
     */
    void replaceAllOrders(List<OrderRequestDTO> ordersDtos);

    /**
     * To delete all orders
     */
    void deleteAllOrders();

    /**
     * To retrieve a specific order based on its ID
     * @param id the ID of the order to retrieve
     * @return the order DTO with the specified DTO
     */
    OrderResponseDTO getOrderById(int id);

    /**
     * To update a specific order based on its ID
     * @param id the ID of the order to update
     * @param orderRequestDTO the order DTO with updated data
     */
    void updateOrder(int id, OrderRequestDTO orderRequestDTO);

    /**
     * To delete a specific order based on its ID
     * @param id the ID of the order to delete
     */
    void deleteOrderById(int id);

}
