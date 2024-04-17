package com.bzu.inventorymanagementsystemAPIs.Controllers;

import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderRequestDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderResponseDTO;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.BadRequestException;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.NotFoundException;
import com.bzu.inventorymanagementsystemAPIs.Models.Order;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Services.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * This class handles HTTP requests related to manage order
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * To create a new order
     * @param order order data to be created
     * @return the created order DTO.
     */
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createOrder(@Valid @RequestBody OrderRequestDTO order)
    {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    /**
     * To retrieve all orders
     * @return list of all orders as DTOs
     */
    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    /**
     * To replace all the existing orders with the provided list
     * @param orders the list of order DTOs to replace the existing orders.
     */
    @PutMapping
    public ResponseEntity replaceAllProducts(@Valid @RequestBody List<OrderRequestDTO> orders){
        orderService.replaceAllOrders(orders);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * To delete all orders
     */
    @DeleteMapping
    public ResponseEntity deleteAllOrders(){
        orderService.deleteAllOrders();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To retrieve a specific order based on its ID
     * @param id the ID of the order to retrieve
     * @return the order DTO with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity <OrderResponseDTO> getProductById(@Valid @PathVariable int id) {
        if(id < 0)
        {
            throw new BadRequestException("inventory",String.valueOf(id));
        }

        OrderResponseDTO orderResponseDTO = orderService.getOrderById(id);
        if(orderResponseDTO == null){
            throw new NotFoundException("order","ID:",id);
        }
        return ResponseEntity.ok(orderResponseDTO);
    }

    /**
     * To update a specific order based on its ID with the provided data
     * @param id the ID of the order to update
     * @param order the order DTO containing the new data
     */
    @PatchMapping("/{id}")
    public ResponseEntity updateOrder (@Valid @PathVariable int id, @Valid @RequestBody OrderRequestDTO order){
        if(id < 0)
        {
            throw new BadRequestException("order",String.valueOf(id));
        }

        orderService.updateOrder(id, order);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To delete a specific order based on its ID
     * @param id the order ID to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderById(@Valid @PathVariable int id){
        if(id < 0)
        {
            throw new BadRequestException("order",String.valueOf(id));
        }

        orderService.deleteOrderById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

