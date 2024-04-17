package com.bzu.inventorymanagementsystemAPIs.Repositories;

import com.bzu.inventorymanagementsystemAPIs.Models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface provides access to the inventory data in the database
 * It extends JpaRepository which provides CRUD operations for the inventory entity
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
}
