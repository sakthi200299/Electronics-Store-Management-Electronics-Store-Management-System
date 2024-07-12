//package com.ElectronicsStoreManagementsystem.dao;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ElectronicsStoreManagementsystem.entity.Orders;
//import com.ElectronicsStoreManagementsystem.repository.Orderrepository;
//
//import java.util.List;
//
//@Component
//public class Orderdao {
//
//    @Autowired
//    private Orderrepository orderRepository;
//
//    public List<Orders> getAllOrders() {
//        return orderRepository.findAll();
//        
//    }
//
//    public Orders getOrderById(int id) {
//        return orderRepository.findById(id).orElse(null);
//    }
//
//    public void createOrder(Orders order) {
//        orderRepository.save(order);
//    }
//
//    public Orders updateOrder(int id, Orders updatedOrder) {
//        Orders order = orderRepository.findById(id).orElse(null);
//        if (order != null) {
//          	order.setCustomer(updatedOrder.getCustomer());
//            order.setOrderDate(updatedOrder.getOrderDate());
//            order.setOrderCost(updatedOrder.getOrderCost());
//            order.setTotalQuantity(updatedOrder.getTotalQuantity());
//        
//            orderRepository.save(order);
//        }
//        return order;
//    }
//
//    public void deleteOrder(int id) {
//        orderRepository.deleteById(id);
//    }
//    public List<Orders> getAllOrdersWithCustomerInfo() {
//        return orderRepository.getAllOrdersWithCustomerInfo();
//    }
//
//  
//}