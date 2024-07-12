package com.ElectronicsStoreManagementsystem.controller;

import com.ElectronicsStoreManagementsystem.entity.Products;
import com.ElectronicsStoreManagementsystem.service.Productservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ElectronicsStore/product")
public class Productcontroller {

    @Autowired
    private Productservice productService;

    @GetMapping("/all")
    public List<Products> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Products> getProductById(@PathVariable int id) {
        Products product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createProduct(@RequestBody Products product) {
        String result = productService.createProduct(product);
        if (result.equals("Product created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestBody Products updatedProduct) {
        String result = productService.updateProduct(id, updatedProduct);
        if (result.equals("Product updated successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable int id) {
        String result = productService.deleteProduct(id);
        if (result.equals("Product deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @PostMapping("/requestforproduct")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Object[]> requestProduct(
            @RequestParam int productId,	
            @RequestParam int totalQuantity,
            @RequestParam int customerId
    ) {
        return productService.requestProduct(productId, totalQuantity, customerId);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Products>> searchProductsByNameAndCostRange(
            @RequestParam String productName,
            @RequestParam(required = false) int minCost,
            @RequestParam(required = false) int maxCost
    ) {
        List<Products> productCosts = productService.findProductCostByNameAndCostRange(productName, minCost, maxCost);
        if (productCosts.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(productCosts);
        }
    }
}
