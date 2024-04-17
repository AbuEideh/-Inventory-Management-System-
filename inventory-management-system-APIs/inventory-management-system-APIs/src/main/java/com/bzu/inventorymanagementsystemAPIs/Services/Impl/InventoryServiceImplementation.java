package com.bzu.inventorymanagementsystemAPIs.Services.Impl;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Inventory;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Repositories.InventoryRepository;
import com.bzu.inventorymanagementsystemAPIs.Repositories.ProductRepository;
import com.bzu.inventorymanagementsystemAPIs.Services.InventoryService;
import com.bzu.inventorymanagementsystemAPIs.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This class provides implementation for managing inventory data
 */
@Service
public class InventoryServiceImplementation implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    private ProductRepository productRepository;
    @Override
    public InventoryDTO createInventory(InventoryDTO inventoryDTO) {
        Inventory inventory = mapToEntity(inventoryDTO);
        inventory = inventoryRepository.save(inventory);
        return mapToDTO(inventory);
    }

    @Override
    public List<InventoryDTO> getAllInventories() {
        return inventoryRepository.findAll().stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void replaceAllInventories(List<InventoryDTO> inventoriesDTO) {
        List<Inventory> inventories = inventoriesDTO.stream().
                map(this::mapToEntity)
                .collect(Collectors.toList());
        inventoryRepository.deleteAll();
        inventoryRepository.saveAll(inventories);
    }

    @Override
    public void deleteAllInventories() {
        inventoryRepository.deleteAll();
    }

    @Override
    public InventoryDTO getInventoryById(int id) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        return optionalInventory.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void updateInventory(int id, InventoryDTO newInventoryDTO) {
        Optional<Inventory> optionalInventory = inventoryRepository.findById(id);
        optionalInventory.ifPresent(inventory -> {
            Product product = productRepository.findById(newInventoryDTO.getProductId()).get();
            inventory.setQuantity(newInventoryDTO.getQuantity());
            inventory.setLastRestockDate(newInventoryDTO.getLastRestockDate());
            inventory.setLocation(newInventoryDTO.getLocation());
            inventoryRepository.save(inventory);
        });
    }

    @Override
    public void deleteInventoryById(int id) {
        inventoryRepository.deleteById(id);
    }

    private InventoryDTO mapToDTO(Inventory inventory) {
        InventoryDTO inventoryDTO = new InventoryDTO();
        inventoryDTO.setId(inventory.getId());
        inventoryDTO.setLocation(inventory.getLocation());
        inventoryDTO.setQuantity(inventory.getQuantity());
        inventoryDTO.setLastRestockDate(inventory.getLastRestockDate());
        inventoryDTO.setProductId(inventory.getProduct().getId());
        return inventoryDTO;
    }

    private Inventory mapToEntity(InventoryDTO inventoryDTO) {
        Product product = productRepository.findById(inventoryDTO.getProductId()).get();
        Inventory inventory = new Inventory();
        inventory.setId(inventoryDTO.getId());
        inventory.setProduct(product);
        inventory.setQuantity(inventoryDTO.getQuantity());
        inventory.setLocation(inventory.getLocation());
        inventory.setLastRestockDate(inventoryDTO.getLastRestockDate());
        return inventory;
    }

}
