package com.ElectronicsStoreManagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicsStoreManagementsystem.entity.Customers;
public interface Customerrepository extends JpaRepository<Customers,Integer>{

	Customers findByCustomerName(String username);

}

