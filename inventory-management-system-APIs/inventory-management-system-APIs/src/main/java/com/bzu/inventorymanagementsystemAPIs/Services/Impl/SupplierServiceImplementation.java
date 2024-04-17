package com.bzu.inventorymanagementsystemAPIs.Services.Impl;
import com.bzu.inventorymanagementsystemAPIs.DTOs.ProductDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.SupplierDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Models.Supplier;
import com.bzu.inventorymanagementsystemAPIs.Repositories.SupplierRepository;
import com.bzu.inventorymanagementsystemAPIs.Services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This class provides implementation for managing supplier data
 */
@Service
public class SupplierServiceImplementation implements SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public SupplierDTO createSupplier(SupplierDTO supplierDTO) {
        Supplier supplier = mapToEntity(supplierDTO);
        supplier = supplierRepository.save(supplier);
        return mapToDTO(supplier);
    }

    @Override
    public List<SupplierDTO> getAllSuppliers() {
        return supplierRepository.findAll().stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void replaceAllSuppliers(List<SupplierDTO> suppliersDTO) {
        List<Supplier> suppliers = suppliersDTO.stream().
                map(this::mapToEntity)
                .collect(Collectors.toList());
        supplierRepository.deleteAll();
        supplierRepository.saveAll(suppliers);
    }

    @Override
    public void deleteAllSuppliers() {
        supplierRepository.deleteAll();
    }

    @Override
    public SupplierDTO getSupplierById(int id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        return optionalSupplier.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void updateSupplier(int id, SupplierDTO newSupplierDTO) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        optionalSupplier.ifPresent(inventory -> {
            Supplier supplier = new Supplier();
            supplier.setId(newSupplierDTO.getId());
            supplier.setName(newSupplierDTO.getName());
            supplier.setPhone(newSupplierDTO.getPhone());
            supplier.setEmail(newSupplierDTO.getEmail());
            supplier.setAddress(newSupplierDTO.getAddress());
            supplierRepository.save(supplier);

    });
    }

    @Override
    public void deleteSupplierById(int id) {
        supplierRepository.deleteById(id);

    }

    private SupplierDTO mapToDTO(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setId(supplier.getId());
        supplierDTO.setAddress(supplier.getAddress());
        supplierDTO.setName(supplier.getName());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setPhone(supplier.getPhone());
        return supplierDTO;
    }

    private Supplier mapToEntity(SupplierDTO supplierDTO) {
        Supplier supplier = new Supplier();
        supplier.setId(supplierDTO.getId());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setName(supplierDTO.getName());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPhone(supplierDTO.getPhone());
        return  supplier;
    }


}
