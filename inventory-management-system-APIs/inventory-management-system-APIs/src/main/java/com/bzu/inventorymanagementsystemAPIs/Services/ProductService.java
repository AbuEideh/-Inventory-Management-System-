package com.bzu.inventorymanagementsystemAPIs.Services;

import com.bzu.inventorymanagementsystemAPIs.DTOs.ProductDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;

import java.util.List;

/**
 * This interface defines operations for managing product data
 */
public interface ProductService {
    /**
     * To create a new product
     * @param product product data to be created
     * @return the created product DTO
     */
    ProductDTO createProduct (ProductDTO productDTO);

    /**
     * To retrieve all products
     * @return the list of all products DTO
     */
    List <ProductDTO> getAllProducts();

    /**
     * To replace all existing products with the provided products list
     * @param products the list of product DTOs to replace the existing ones.
     */
    void replaceAllProducts(List<ProductDTO> productsDTO);

    /**
     * To delete all products
     */
    void deleteAllProducts();

    /**
     * To retrieve a specific product based on its ID
     * @param id the ID of the product to retrieve
     * @return the product DTO with the specified DTO
     */
    ProductDTO getProductById(int id);

    /**
     * To update a specific order based on its ID
     * @param id the ID of the product to update
     * @param product the product DTO with updated data
     */
    void updateProduct(int id, ProductDTO productDTO);

    /**
     * To delete a specific product based on its ID
     * @param id the ID of the product to delete
     */
    void deleteProductById(int id);
}
