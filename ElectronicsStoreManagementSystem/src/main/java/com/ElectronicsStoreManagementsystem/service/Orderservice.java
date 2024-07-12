package com.ElectronicsStoreManagementsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ElectronicsStoreManagementsystem.entity.Orders;
import com.ElectronicsStoreManagementsystem.repository.Orderrepository;

import jakarta.transaction.Transactional;

import java.util.Collections;
import java.util.List;
@Service
public class Orderservice {

    @Autowired
    private Orderrepository orderRepository;

    public List<Orders> getAllOrders() {
        try {
            return orderRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public Orders getOrderById(int id) {
        try {
            return orderRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String createOrder(Orders order) {
        try {
            orderRepository.save(order);
            return "Order created successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create order: " + e.getMessage();
        }
    }

    public String updateOrder(int id, Orders updatedOrder) {
        try {
            if (orderRepository.existsById(id)) {
                updatedOrder.setOrderId(id); // Ensure the ID is set for the update
                orderRepository.save(updatedOrder);
                return "Order updated successfully";
            } else {
                return "Order not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update order: " + e.getMessage();
        }
    }

    public String deleteOrder(int id) {
        try {
            if (orderRepository.existsById(id)) {
                orderRepository.deleteById(id);
                return "Order deleted successfully";
            } else {
                return "Order not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete order: " + e.getMessage();
        }
    }
    
    @Transactional
    public List<Object[]> processPayment(int orderId, String customerName, int amount) {
        try {
            return orderRepository.processPaymentForOrder(orderId, customerName, amount);
        } catch (Exception e) {
            e.printStackTrace(); // Example: Print stack trace for debugging
            return Collections.emptyList();
        }
    }

   
}