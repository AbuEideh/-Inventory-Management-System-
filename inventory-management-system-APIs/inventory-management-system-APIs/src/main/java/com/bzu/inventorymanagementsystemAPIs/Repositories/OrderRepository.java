package com.bzu.inventorymanagementsystemAPIs.Repositories;

import com.bzu.inventorymanagementsystemAPIs.Models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides access to the order data in the database
 * It extends JpaRepository which provides CRUD operations for the order entity
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
