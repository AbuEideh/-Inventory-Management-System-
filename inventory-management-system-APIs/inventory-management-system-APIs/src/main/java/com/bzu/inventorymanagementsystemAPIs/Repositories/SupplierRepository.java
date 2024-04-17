package com.bzu.inventorymanagementsystemAPIs.Repositories;

import com.bzu.inventorymanagementsystemAPIs.Models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides access to the supplier data in the database
 * It extends JpaRepository which provides CRUD operations for the supplier entity
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}