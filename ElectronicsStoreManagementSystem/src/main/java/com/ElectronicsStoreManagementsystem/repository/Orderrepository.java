package com.ElectronicsStoreManagementsystem.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import com.ElectronicsStoreManagementsystem.entity.Orders;
public interface Orderrepository extends JpaRepository<Orders,Integer> {
	
	@Procedure(name ="processPaymentForOrder")
    List<Object[]>processPaymentForOrder(@Param("orderId") int orderId,
                                          @Param("customerName") String customerName,
                                          @Param("amount") int amount);
}


