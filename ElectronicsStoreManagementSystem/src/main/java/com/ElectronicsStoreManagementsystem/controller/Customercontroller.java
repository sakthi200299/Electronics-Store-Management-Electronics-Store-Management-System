package com.ElectronicsStoreManagementsystem.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

import com.ElectronicsStoreManagementsystem.entity.Customers;
import com.ElectronicsStoreManagementsystem.service.Customerservice;

@RestController
@RequestMapping("/ElectronicsStore/customer")

public class Customercontroller {

	@Autowired
    private Customerservice customerService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllCustomers() {
        Map<String, Object> response = customerService.getAllCustomers();
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getCustomerById(@PathVariable int id) {
        Map<String, Object> response = customerService.getCustomerById(id);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else if (response.get("message").equals("Customer not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/name/{customerName}")
    public ResponseEntity<Customers> getCustomerByName(@PathVariable String customerName) {
        Customers customer = customerService.getCustomerByName(customerName);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Object>> createCustomer(@RequestBody Customers customer) {
        Map<String, Object> response = customerService.createCustomer(customer);
        if (response.get("status").equals("success")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateCustomer(@PathVariable int id, @RequestBody Customers updatedCustomer) {
        Map<String, Object> response = customerService.updateCustomer(id, updatedCustomer);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else if (response.get("message").equals("Customer not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteCustomer(@PathVariable int id) {
        Map<String, Object> response = customerService.deleteCustomer(id);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else if (response.get("message").equals("Customer not found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Map<String, Object>> authenticateCustomer(@RequestBody Customers customer) {
        Map<String, Object> response = customerService.authenticateCustomer(customer.getCustomerName(), customer.getCustomerPassword());
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

}