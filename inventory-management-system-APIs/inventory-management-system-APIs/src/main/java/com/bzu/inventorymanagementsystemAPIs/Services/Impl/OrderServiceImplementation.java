package com.bzu.inventorymanagementsystemAPIs.Services.Impl;

import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderRequestDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.OrderResponseDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Inventory;
import com.bzu.inventorymanagementsystemAPIs.Models.Order;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Models.Supplier;
import com.bzu.inventorymanagementsystemAPIs.Repositories.OrderRepository;
import com.bzu.inventorymanagementsystemAPIs.Repositories.ProductRepository;
import com.bzu.inventorymanagementsystemAPIs.Repositories.SupplierRepository;
import com.bzu.inventorymanagementsystemAPIs.Services.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This class provides implementation for managing order data
 */
@Service
public class OrderServiceImplementation implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private SupplierRepository supplierRepository;
    @Autowired
    private ProductRepository productRepository;
    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {
        Order order = mapRequestToEntity(orderRequestDTO);
        order = orderRepository.save(order);
        return mapToResponseDTO(order);
    }

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll().stream().map(this::mapToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void replaceAllOrders(List<OrderRequestDTO> ordersDtos) {
        List<Order> orders = ordersDtos.stream().
                map(this::mapRequestToEntity)
                .collect(Collectors.toList());
        orderRepository.deleteAll();
        orderRepository.saveAll(orders);
    }

    @Override
    public void deleteAllOrders() {
        orderRepository.deleteAll();
    }

    @Override
    public OrderResponseDTO getOrderById(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        return optionalOrder.map(this::mapToResponseDTO).orElse(null);
    }

    @Override
    public void updateOrder(int id, OrderRequestDTO newOrderDTO) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        optionalOrder.ifPresent(order -> {
            Supplier supplier = supplierRepository.findById(newOrderDTO.getId()).get();
            List<Product> products = productRepository.findAllById(newOrderDTO.getProductIds()).stream().toList();
            order.setId(newOrderDTO.getId());
            order.setSupplier(supplier);
            order.setProducts(products);
            order.setQuantity(newOrderDTO.getQuantity());
            order.setOrderDate(newOrderDTO.getOrderDate());
            order.setDeliveryDate(newOrderDTO.getDeliveryDate());
            order.setOrderStatus(newOrderDTO.getOrderStatus());
            orderRepository.save(order);
        });
    }

    @Override
    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);
    }

    private OrderResponseDTO mapToResponseDTO(Order order) {
        OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
        orderResponseDTO.setId(order.getId());
        orderResponseDTO.setSupplierId(order.getSupplier().getId());
        orderResponseDTO.setProducts(order.getProducts());
        orderResponseDTO.setQuantity(order.getQuantity());
        orderResponseDTO.setOrderDate(order.getOrderDate());
        orderResponseDTO.setDeliveryDate(order.getDeliveryDate());
        orderResponseDTO.setOrderStatus(order.getOrderStatus());
        return orderResponseDTO;
    }

    private Order mapResponseToEntity(OrderResponseDTO orderResponseDTO) {
        Order order = new Order();
        Supplier supplier = supplierRepository.findById(orderResponseDTO.getId()).get();
        order.setId(orderResponseDTO.getId());
        order.setSupplier(supplier);
        order.setProducts(orderResponseDTO.getProducts());
        order.setQuantity(orderResponseDTO.getQuantity());
        order.setOrderDate(orderResponseDTO.getOrderDate());
        order.setDeliveryDate(orderResponseDTO.getDeliveryDate());
        order.setOrderStatus(orderResponseDTO.getOrderStatus());
        return order;
    }

    private OrderRequestDTO mapToRequestDTO(Order order) {
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setId(order.getId());
        orderRequestDTO.setSupplierId(order.getSupplier().getId());
        orderRequestDTO.setProductIds(order.getProducts().stream().map((Product::getId)).toList());
        orderRequestDTO.setQuantity(order.getQuantity());
        orderRequestDTO.setOrderDate(order.getOrderDate());
        orderRequestDTO.setDeliveryDate(order.getDeliveryDate());
        orderRequestDTO.setOrderStatus(order.getOrderStatus());
        return orderRequestDTO;
    }

    private Order mapRequestToEntity(OrderRequestDTO orderRequestDTO) {
        Order order = new Order();
        Supplier supplier = supplierRepository.findById(orderRequestDTO.getId()).get();
        List<Product> products = productRepository.findAllById(orderRequestDTO.getProductIds()).stream().toList();
        order.setId(orderRequestDTO.getId());
        order.setSupplier(supplier);
        order.setProducts(products);
        order.setQuantity(orderRequestDTO.getQuantity());
        order.setOrderDate(orderRequestDTO.getOrderDate());
        order.setDeliveryDate(orderRequestDTO.getDeliveryDate());
        order.setOrderStatus(orderRequestDTO.getOrderStatus());
        return order;
    }
}
