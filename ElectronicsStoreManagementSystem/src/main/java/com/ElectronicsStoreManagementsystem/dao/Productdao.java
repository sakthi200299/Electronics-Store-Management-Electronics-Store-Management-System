//package com.ElectronicsStoreManagementsystem.dao;
//
//import com.ElectronicsStoreManagementsystem.entity.Products;
//import com.ElectronicsStoreManagementsystem.repository.Productrepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class Productdao {
//
//    @Autowired
//    private Productrepository productRepository;
//
//    public List<Products> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public Products getProductById(int id) {
//        return productRepository.findById(id).orElse(null);
//    }
//
//    public void createProduct(Products product) {
//        productRepository.save(product);
//    }
//
//    public Products updateProduct(int id, Products updatedProduct) {
//        if (productRepository.existsById(id)) {
//            return productRepository.save(updatedProduct);
//        }
//        return null;
//    }
//
//    public void deleteProduct(int id) {
//        productRepository.deleteById(id);
//    }
//
//    public List<Object[]> requestProduct(int productId, int totalQuantity, int OrderId) {
//        return productRepository.requestProduct(productId, totalQuantity, OrderId);
//    }
//    
//}
