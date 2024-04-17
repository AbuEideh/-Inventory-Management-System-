package com.bzu.inventorymanagementsystemAPIs.Controllers;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.BadRequestException;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.NotFoundException;
import com.bzu.inventorymanagementsystemAPIs.Services.InventoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * This class handles HTTP requests related to manage inventory
 */
@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    /**
     * To create a new inventory
     * @param inventoryDTO inventory data to be created
     * @return the created inventory DTO.
     */
    @PostMapping
    public ResponseEntity<InventoryDTO> createInventory(@Valid @RequestBody InventoryDTO inventoryDTO)
    {

        return ResponseEntity.ok(inventoryService.createInventory(inventoryDTO));
    }

    /**
     * To retrieve all inventories
     *
     * @return list of all inventories as DTOs
     */
    @GetMapping
    public ResponseEntity<List<InventoryDTO>> getAllInventories(){
        return ResponseEntity.ok(inventoryService.getAllInventories());
    }

    /**
     * To replace all the existing inventories with the provided list
     * @param inventoriesDTO the list of inventory DTOs to replace the existing inventories.
     */
    @PutMapping
    public ResponseEntity replaceAllInventories(@Valid @RequestBody List<InventoryDTO> inventoriesDTO){

        inventoryService.replaceAllInventories(inventoriesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * To delete all inventories
     */
    @DeleteMapping
    public ResponseEntity deleteAllInventories(){
        inventoryService.deleteAllInventories();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To retrieve a specific inventory based on its ID
     *
     * @param id the ID of the inventory to retrieve
     * @return the inventory DTO with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<InventoryDTO> getInventoryById(@Valid @PathVariable int id) {
        if(id < 0)
        {
            throw new BadRequestException("inventory",String.valueOf(id));
        }

        InventoryDTO inventoryDTO = inventoryService.getInventoryById(id);
        if(inventoryDTO == null){
            throw new NotFoundException("inventory","ID:",id);
        }
        return ResponseEntity.ok(inventoryDTO);
    }

    /**
     * To update a specific inventory based on its ID with the provided data
     *
     * @param id  the ID of the inventory to update
     * @param inventoryDTO the inventory DTO containing the new data
     * @return
     */
    @PatchMapping("/{id}")
    public ResponseEntity updateInventory (@Valid @PathVariable int id, @Valid @RequestBody InventoryDTO inventoryDTO){

        if(id < 0)
        {
            throw new BadRequestException("inventory",String.valueOf(id));
        }

        inventoryService.updateInventory(id, inventoryDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To delete a specific inventory based on its ID
     * @param id the inventory ID to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteInventoryById(@Valid @PathVariable int id){
        if(id < 0)
        {
            throw new BadRequestException("inventory",String.valueOf(id));
        }

        inventoryService.deleteInventoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
