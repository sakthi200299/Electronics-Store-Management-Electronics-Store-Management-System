package com.ElectronicsStoreManagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.ElectronicsStoreManagementsystem.entity.Orders;
import com.ElectronicsStoreManagementsystem.service.Orderservice;

import java.util.List;

@RestController
@RequestMapping("/ElectronicsStore/orders")

public class Ordercontroller {


    @Autowired
    private Orderservice orderService;

    @GetMapping("/all")
    public List<Orders> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Orders> getOrderById(@PathVariable int id) {
        Orders order = orderService.getOrderById(id);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> createOrder(@RequestBody Orders order) {
        String result = orderService.createOrder(order);
        if (result.equals("Order created successfully")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Orders updatedOrder) {
        String result = orderService.updateOrder(id, updatedOrder);
        if (result.equals("Order updated successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
        String result = orderService.deleteOrder(id);
        if (result.equals("Order deleted successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(result);
        }
    }
    
    @PostMapping("/processPayment")
    public ResponseEntity<List<Object[]>> processPayment(@RequestParam int orderId,
                                                         @RequestParam String customerName,
                                                         @RequestParam int amount) {
        List<Object[]> paymentResult = orderService.processPayment(orderId, customerName, amount);
        HttpHeaders headers = new HttpHeaders();
        if (!paymentResult.isEmpty()) {
            headers.add("Message", "Payment successful");
            return new ResponseEntity<>(paymentResult, headers, HttpStatus.OK);
        } else {
            headers.add("Message", "Payment not successful");
            return new ResponseEntity<>(paymentResult, headers, HttpStatus.NOT_FOUND);
        }
    }
    
}
