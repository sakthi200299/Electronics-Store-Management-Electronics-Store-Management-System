package com.ElectronicsStoreManagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ElectronicsStoreManagementsystem.entity.OrderProduct;

@Repository
public interface OrderProductrepository extends JpaRepository<OrderProduct, Integer> {
	
}
