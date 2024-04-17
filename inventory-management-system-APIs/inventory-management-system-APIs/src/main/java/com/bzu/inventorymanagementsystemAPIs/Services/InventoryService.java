package com.bzu.inventorymanagementsystemAPIs.Services;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;

import java.util.List;

/**
 * This interface defines operations for managing inventory data
 */
public interface InventoryService {
    /**
     * To create a new inventory
     * @param inventory inventory data to be created
     * @return the created inventory DTO
     */
    InventoryDTO createInventory(InventoryDTO inventory);

    /**
     * To retrieve all inventories
     * @return the list of all inventories DTO
     */
    List<InventoryDTO> getAllInventories();

    /**
     * To replace all existing inventories with the provided inventories list
     * @param inventories the list of inventory DTOs to replace the existing ones.
     */
    void replaceAllInventories(List<InventoryDTO> inventories);

    /**
     * To delete all inventories
     */
    void deleteAllInventories();

    /**
     * To retrieve a specific inventory based on its ID
     * @param id the ID of the inventory to retrieve
     * @return the inventory DTO with the specified DTO
     */
    InventoryDTO getInventoryById(int id);

    /**
     * To update a specific inventory based on its ID
     * @param id the ID of the inventory to update
     * @param inventory the inventory DTO with updated data
     */
    void updateInventory(int id, InventoryDTO inventory);

    /**
     * To delete a specific inventory based on its ID
     * @param id the ID of the inventory to delete
     */
    void deleteInventoryById(int id);

}
