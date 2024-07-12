//package com.ElectronicsStoreManagementsystem.dao;
//
//import com.ElectronicsStoreManagementsystem.entity.Customers;
//import com.ElectronicsStoreManagementsystem.repository.Customerrepository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class Customerdao {
//
//    @Autowired
//    private Customerrepository customerRepository;
//
//    public List<Customers> getAllCustomers() {
//        return customerRepository.findAll();
//    }
//
//    public Customers getCustomerById(int id) {
//        return customerRepository.findById(id).orElse(null);
//    }
//
//    public void createCustomer(Customers customer) {
//    	customerRepository.save(customer);
//    }
//
//    public Customers updateCustomer(int id, Customers updatedCustomer) {
//        Customers customer = customerRepository.findById(id).orElse(null);
//        if (customer != null) {
//        	customer.setCustomerName(updatedCustomer.getCustomerName());
//            customer.setCustomerPhone(updatedCustomer.getCustomerPhone());
//            customer.setCustomerPassword(updatedCustomer.getCustomerPassword());
//            customer. setRole(updatedCustomer.getRole());
//            customerRepository.save(customer);
//        }
//        return customer;
//    }
//
//    public void deleteCustomer(int id) 
//    {
//    	   customerRepository.deleteById(id);
//    }
//    public Customers findByCustomerName(String username) {
//        return customerRepository.findByCustomerName(username);
//    }
//   
//
//}