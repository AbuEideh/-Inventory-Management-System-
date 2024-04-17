package com.bzu.inventorymanagementsystemAPIs.Services.Impl;
import com.bzu.inventorymanagementsystemAPIs.DTOs.InventoryDTO;
import com.bzu.inventorymanagementsystemAPIs.DTOs.ProductDTO;
import com.bzu.inventorymanagementsystemAPIs.Models.Inventory;
import com.bzu.inventorymanagementsystemAPIs.Models.Product;
import com.bzu.inventorymanagementsystemAPIs.Repositories.ProductRepository;
import com.bzu.inventorymanagementsystemAPIs.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This class provides implementation for managing product data
 */
@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = mapToEntity(productDTO);
        product = productRepository.save(product);
        return mapToDTO(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream().map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void replaceAllProducts(List<ProductDTO> productsDTO) {
        List<Product> products = productsDTO.stream().
                map(this::mapToEntity)
                .collect(Collectors.toList());
        productRepository.deleteAll();
        productRepository.saveAll(products);
    }

    @Override
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }

    @Override
    public ProductDTO getProductById(int id) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.map(this::mapToDTO).orElse(null);
    }

    @Override
    public void updateProduct(int id, ProductDTO newProductDTO) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        optionalProduct.ifPresent(inventory -> {
            Product product = productRepository.findById(newProductDTO.getId()).get();
            product.setName(newProductDTO.getName());
            product.setDescription(newProductDTO.getDescription());
            product.setPrice(newProductDTO.getPrice());
            product.setSupplier(newProductDTO.getSupplier());
            product.setQuantity_available(newProductDTO.getQuantityAvailable());
            productRepository.save(product);
        });
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteById(id);
    }

    private ProductDTO mapToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setSupplier(product.getSupplier());
        productDTO.setQuantityAvailable(product.getQuantity_available());
        return productDTO;
    }

    private Product mapToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setSupplier(productDTO.getSupplier());
        product.setQuantity_available(productDTO.getQuantityAvailable());
        return product;
    }
}
