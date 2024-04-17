package com.bzu.inventorymanagementsystemAPIs.Repositories;

import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides access to the product data in the database
 * It extends JpaRepository which provides CRUD operations for the product entity
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
