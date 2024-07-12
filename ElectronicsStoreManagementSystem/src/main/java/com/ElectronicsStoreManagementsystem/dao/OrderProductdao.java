//package com.ElectronicsStoreManagementsystem.dao;
//import com.ElectronicsStoreManagementsystem.entity.OrderProduct;
//import com.ElectronicsStoreManagementsystem.repository.OrderProductrepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//@Repository
//public class OrderProductdao {
//
//    @Autowired
//    private OrderProductrepository orderProductRepository;
//
//    public List<OrderProduct> getAllOrderProducts() {
//        return orderProductRepository.findAll();
//    }
//
//    public OrderProduct getOrderProductById(int id) {
//        return orderProductRepository.findById(id).orElse(null);
//    }
//
//    public void createOrderProduct(OrderProduct orderProduct) {
//        orderProductRepository.save(orderProduct);
//    }
//
//    public OrderProduct updateOrderProduct(int id, OrderProduct updatedOrderProduct) {
//        OrderProduct existingOrderProduct = orderProductRepository.findById(id).orElse(null);
//        if (existingOrderProduct != null) {
//            existingOrderProduct.setOrderId(updatedOrderProduct.getOrderId());
//            existingOrderProduct.setProductId(updatedOrderProduct.getProductId());
//            existingOrderProduct.setProductQuantity(updatedOrderProduct.getProductQuantity());
//            existingOrderProduct.setProductCost(updatedOrderProduct.getProductCost());
//            existingOrderProduct.setItemName(updatedOrderProduct.getItemName());
//            return orderProductRepository.save(existingOrderProduct);
//        } else {
//            return null;
//        }
//    }
//
//    public void deleteOrderProduct(int id) {
//        if (orderProductRepository.existsById(id)) {
//            orderProductRepository.deleteById(id);
//        }
//    }
//
//}
