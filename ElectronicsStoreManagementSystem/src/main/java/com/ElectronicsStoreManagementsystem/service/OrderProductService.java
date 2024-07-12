package com.ElectronicsStoreManagementsystem.service;
import com.ElectronicsStoreManagementsystem.entity.OrderProduct;
import com.ElectronicsStoreManagementsystem.repository.OrderProductrepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
public class OrderProductService {
	@Autowired
    private OrderProductrepository orderProductRepository;

    public List<OrderProduct> getAllOrderProducts() {
        try {
            return orderProductRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public OrderProduct getOrderProductById(int id) {
        try {
            return orderProductRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String createOrderProduct(OrderProduct orderProduct) {
        try {
            orderProductRepository.save(orderProduct);
            return "Order product created successfully";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to create order product: " + e.getMessage();
        }
    }

    public String updateOrderProduct(int id, OrderProduct updatedOrderProduct) {
        try {
            if (orderProductRepository.existsById(id)) {
                OrderProduct existingOrderProduct = orderProductRepository.findById(id).orElse(null);
                if (existingOrderProduct != null) {
                    existingOrderProduct.setOrderId(updatedOrderProduct.getOrderId());
                    existingOrderProduct.setProductId(updatedOrderProduct.getProductId());
                    existingOrderProduct.setProductQuantity(updatedOrderProduct.getProductQuantity());
                    existingOrderProduct.setProductCost(updatedOrderProduct.getProductCost());
                    existingOrderProduct.setItemName(updatedOrderProduct.getItemName());
                    orderProductRepository.save(existingOrderProduct);
                    return "Order product updated successfully";
                } else {
                    return "Order product not found";
                }
            } else {
                return "Order product not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to update order product: " + e.getMessage();
        }
    }

    public String deleteOrderProduct(int id) {
        try {
            if (orderProductRepository.existsById(id)) {
                orderProductRepository.deleteById(id);
                return "Order product deleted successfully";
            } else {
                return "Order product not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to delete order product: " + e.getMessage();
        }
    }
}
