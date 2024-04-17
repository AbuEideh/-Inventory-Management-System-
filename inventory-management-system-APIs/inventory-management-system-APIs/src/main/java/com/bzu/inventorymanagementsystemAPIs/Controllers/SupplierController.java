package com.bzu.inventorymanagementsystemAPIs.Controllers;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.SupplierDTO;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.BadRequestException;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.NotFoundException;
import com.bzu.inventorymanagementsystemAPIs.Models.Supplier;
import com.bzu.inventorymanagementsystemAPIs.Services.SupplierService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * This class handles HTTP requests related to manage supplier
 */
@RestController
@RequestMapping("/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    /**
     * To create a new supplier
     * @param supplierDTO supplier data to be created
     * @return the created supplier DTO.
     */
    @PostMapping
    public ResponseEntity<SupplierDTO> createSuPSupplier(@Valid  @RequestBody SupplierDTO supplierDTO)
    {
        return ResponseEntity.ok(supplierService.createSupplier(supplierDTO));
    }

    /**
     * To retrieve all suppliers
     * @return list of all suppliers as DTOs
     */
    @GetMapping
    public ResponseEntity<List<SupplierDTO>> getAllSupplier(){
        return ResponseEntity.ok(supplierService.getAllSuppliers());
    }

    /**
     * To replace all the existing suppliers with the provided list
     * @param suppliersDTO the list of supplier DTOs to replace the existing suppliers.
     */
    @PutMapping
    public ResponseEntity replaceAllSupplier(@Valid @RequestBody List<SupplierDTO> suppliersDTO){
        supplierService.replaceAllSuppliers(suppliersDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * To delete all suppliers
     */
    @DeleteMapping
    public ResponseEntity deleteAllPSuppliers(){
        supplierService.deleteAllSuppliers();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To retrieve a specific supplier based on its ID
     * @param id the ID of the supplier to retrieve
     * @return the supplier DTO with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDTO> getSupplierById(@Valid @PathVariable int id) {
        if(id < 0)
        {
            throw new BadRequestException("supplier",String.valueOf(id));
        }

        SupplierDTO supplierDTO = supplierService.getSupplierById(id);
        if(supplierDTO == null){
            throw new NotFoundException("inventory","ID:",id);
        }
        return ResponseEntity.ok(supplierDTO);
    }

    /**
     * To update a specific supplier based on its ID with the provided data
     * @param id the ID of the supplier to update
     * @param supplierDTO the supplier DTO containing the new data
     */
    @PatchMapping("/{id}")
    public ResponseEntity updateSupplier (@Valid @PathVariable int id, @Valid @RequestBody SupplierDTO supplierDTO){
        if(id < 0)
        {
            throw new BadRequestException("supplier",String.valueOf(id));
        }

        supplierService.updateSupplier(id, supplierDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To delete a specific supplier based on its ID
     * @param id the supplier ID to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteSupplierById(@Valid @PathVariable int id){
        if(id < 0)
        {
            throw new BadRequestException("supplier",String.valueOf(id));
        }

        supplierService.deleteSupplierById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
