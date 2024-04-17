package com.bzu.inventorymanagementsystemAPIs.Services;

import com.bzu.inventorymanagementsystemAPIs.DTOs.SupplierDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * This interface defines operations for managing supplier data
 */
public interface SupplierService {
    /**
     * To create a new supplier
     * @param supplierDTO supplier data to be created
     * @return the created supplier DTO
     */
    SupplierDTO createSupplier(SupplierDTO supplierDTO);

    /**
     * To retrieve all suppliers
     * @return the list of all suppliers DTO
     */
    List<SupplierDTO> getAllSuppliers();

    /**
     * To replace all existing suppliers with the provided products list
     * @param suppliersDTO the list of supplier DTOs to replace the existing ones.
     */
    void replaceAllSuppliers(List<SupplierDTO> suppliersDTO);

    /**
     * To delete all suppliers
     */
    void deleteAllSuppliers();

    /**
     * To retrieve a specific supplier based on its ID
     * @param id the ID of the supplier to retrieve
     * @return the supplier DTO with the specified DTO
     */
    SupplierDTO getSupplierById(int id);

    /**
     * To update a specific supplier based on its ID
     * @param id the ID of the supplier to update
     * @param supplierDTO the supplier DTO with updated data
     */
    void updateSupplier(int id, SupplierDTO supplierDTO);

    /**
     * To delete a specific supplier based on its ID
     * @param id the ID of the supplier to delete
     */
    void deleteSupplierById(int id);


}
