package com.ElectronicsStoreManagementsystem.service;
import com.ElectronicsStoreManagementsystem.entity.Products;
import com.ElectronicsStoreManagementsystem.repository.Productrepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class Productservice {


    @Autowired
    private Productrepository productRepository;

    public List<Products> getAllProducts() {
        try {
            return productRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Products getProductById(int id) {
        try {
            return productRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String createProduct(Products product) {
        try {
            productRepository.save(product);
            return "Product created successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create product: " + e.getMessage();
        }
    }

    public String updateProduct(int id, Products updatedProduct) {
        try {
            if (productRepository.existsById(id)) {
                updatedProduct.setProductId(id); // Ensure the ID is set for the update
                productRepository.save(updatedProduct);
                return "Product updated successfully";
            } else {
                return "Product not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update product: " + e.getMessage();
        }
    }

    public String deleteProduct(int id) {
        try {
            if (productRepository.existsById(id)) {
                productRepository.deleteById(id);
                return "Product deleted successfully";
            } else {
                return "Product not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete product: " + e.getMessage();
        }
    }

    @Transactional
    public List<Object[]> requestProduct(int productId, int totalQuantity, int customerId) {
        try {
            return productRepository.requestProduct(productId, totalQuantity, customerId);
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    public List<Products> findProductCostByNameAndCostRange(String productName, int minCost, int maxCost) {
        try {
            return productRepository.findProductCostByNameAndCostRange(productName, minCost, maxCost);
        } catch (Exception e) {	
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
