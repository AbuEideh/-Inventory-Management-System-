package com.bzu.inventorymanagementsystemAPIs.Controllers;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.ProductDTO;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.BadRequestException;
import com.bzu.inventorymanagementsystemAPIs.Exceptions.NotFoundException;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 * This class handles HTTP requests related to manage product
 */
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * To create a new product
     * @param productDTO product data to be created
     * @return the created product DTO.
     */
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDTO)
    {
        return ResponseEntity.ok(productService.createProduct(productDTO));
    }

    /**
     * To retrieve all products
     * @return list of all products as DTOs
     */
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProducts());
    }

    /**
     * To replace all the existing products with the provided list
     * @param productsDTO the list of product DTOs to replace the existing products.
     */
    @PutMapping
    public ResponseEntity replaceAllProducts(@Valid @RequestBody List<ProductDTO> productsDTO){
        productService.replaceAllProducts(productsDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * To delete all products
     */
    @DeleteMapping
    public ResponseEntity deleteAllProducts(){
        productService.deleteAllProducts();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To retrieve a specific product based on its ID
     * @param id the ID of the product to retrieve
     * @return the product DTO with the specified ID
     */
    @GetMapping("/{id}")
    public ResponseEntity <ProductDTO> getProductById(@Valid @PathVariable int id) {
        if(id < 0)
        {
            throw new BadRequestException("product",String.valueOf(id));
        }

        ProductDTO productDTO = productService.getProductById(id);
        if(productDTO == null){
            throw new NotFoundException("inventory","ID:",id);
        }
        return ResponseEntity.ok(productDTO);
    }

    /**
     * To update a specific product based on its ID with the provided data
     * @param id the ID of the product to update
     * @param productDTO the product DTO containing the new data
     */
    @PatchMapping("/{id}")
    public ResponseEntity updateProduct (@Valid @PathVariable int id, @Valid @RequestBody ProductDTO productDTO){
        if(id < 0)
        {
            throw new BadRequestException("inventory",String.valueOf(id));
        }

        productService.updateProduct(id, productDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    /**
     * To delete a specific product based on its ID
     * @param id the product ID to delete
     */
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductById(@Valid @PathVariable int id){
        if(id < 0)
        {
            throw new BadRequestException("product",String.valueOf(id));
        }

        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    }

