package com.ElectronicsStoreManagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ElectronicsStoreManagementsystem.entity.OrderProduct;
import com.ElectronicsStoreManagementsystem.service.OrderProductService;

import java.util.List;

@RestController
@RequestMapping("/ElectronicsStore/orderproducts")
public class OrderProductcontroller {

    @Autowired
    private OrderProductService orderProductService;

    @GetMapping("/all")
    public List<OrderProduct> getAllOrderProducts() {
        return orderProductService.getAllOrderProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderProduct> getOrderProductById(@PathVariable int id) {
        OrderProduct orderProduct = orderProductService.getOrderProductById(id);
        if (orderProduct != null) {
            return ResponseEntity.ok(orderProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createOrderProduct(@RequestBody OrderProduct orderProduct) {
        String result = orderProductService.createOrderProduct(orderProduct);
        if (result.equals("Order product created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrderProduct(@PathVariable int id, @RequestBody OrderProduct updatedOrderProduct) {
        String result = orderProductService.updateOrderProduct(id, updatedOrderProduct);
        if (result.equals("Order product updated successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrderProduct(@PathVariable int id) {
        String result = orderProductService.deleteOrderProduct(id);
        if (result.equals("Order product deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
}
