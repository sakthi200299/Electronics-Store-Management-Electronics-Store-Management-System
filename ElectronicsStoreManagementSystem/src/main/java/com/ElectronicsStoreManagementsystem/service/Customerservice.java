package com.ElectronicsStoreManagementsystem.service;


import com.ElectronicsStoreManagementsystem.entity.Customers;
import com.ElectronicsStoreManagementsystem.repository.Customerrepository;
import com.google.common.base.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class Customerservice {


	  @Autowired
	    private Customerrepository customerRepository;

	    public Map<String, Object> getAllCustomers() {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            List<Customers> customers = customerRepository.findAll();
	            response.put("status", "success");
	            response.put("customers", customers);
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", e.getMessage());
	        }
	        return response;
	    }

	    public Map<String, Object> getCustomerById(int id) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            Customers customer = customerRepository.findById(id).orElse(null);
	            if (customer != null) {
	                response.put("status", "success");
	                response.put("customer", customer);
	            } else {
	                response.put("status", "error");
	                response.put("message", "Customer not found");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", e.getMessage());
	        }
	        return response;
	    }

	    public Customers getCustomerByName(String customerName) {
	        try {
	            Customers customerOptional = customerRepository.findByCustomerName(customerName);
	            return customerOptional; 
	        } catch (Exception e) {
	            e.printStackTrace(); // Handle or log the exception as per your application's logging strategy
	            return null; // Return null or handle the error condition appropriately
	        }
	    }

	    public Map<String, Object> createCustomer(Customers customer) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            customerRepository.save(customer);
	            response.put("status", "success");
	            response.put("message", "Customer created successfully");
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", "Failed to create customer: " + e.getMessage());
	        }
	        return response;
	    }

	    public Map<String, Object> updateCustomer(int id, Customers updatedCustomer) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            Customers customer = customerRepository.findById(id).orElse(null);
	            if (customer != null) {
	                customer.setCustomerName(updatedCustomer.getCustomerName());
	                customer.setCustomerPhone(updatedCustomer.getCustomerPhone());
	                customer.setCustomerPassword(updatedCustomer.getCustomerPassword());
	                customer.setRole(updatedCustomer.getRole());
	                customerRepository.save(customer);
	                response.put("status", "success");
	                response.put("message", "Customer updated successfully");
	            } else {
	                response.put("status", "error");
	                response.put("message", "Customer not found");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", "Failed to update customer: " + e.getMessage());
	        }
	        return response;
	    }

	    public Map<String, Object> deleteCustomer(int id) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            if (customerRepository.existsById(id)) {
	                customerRepository.deleteById(id);
	                response.put("status", "success");
	                response.put("message", "Customer deleted successfully");
	            } else {
	                response.put("status", "error");
	                response.put("message", "Customer not found");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", "Failed to delete customer: " + e.getMessage());
	        }
	        return response;
	    }

	    public Map<String, Object> authenticateCustomer(String username, String password) {
	        Map<String, Object> response = new HashMap<>();
	        try {
	            Customers customer = customerRepository.findByCustomerName(username);
	            if (customer != null && password.equals(customer.getCustomerPassword())) {
	                response.put("status", "success");
	                response.put("message", "Authentication successful");
	                response.put("customerId", customer.getCustomerId()); // Optional: Add additional information if needed
	            } else {
	                response.put("status", "error");
	                response.put("message", "Authentication failed");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            response.put("status", "error");
	            response.put("message", e.getMessage());
	        }
	        return response;
	    }
}