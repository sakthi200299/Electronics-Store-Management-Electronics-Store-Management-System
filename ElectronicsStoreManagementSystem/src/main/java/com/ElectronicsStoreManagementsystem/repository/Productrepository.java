package com.ElectronicsStoreManagementsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ElectronicsStoreManagementsystem.entity.Products;

@Repository
public interface Productrepository extends JpaRepository<Products, Integer> {
    
	@Procedure(name = "RequestProduct")
    List<Object[]> requestProduct(@Param("productId") int productId,
                                  @Param("totalQuantity") int totalQuantity,
                                  @Param("customerId") int customerId);
    
    
    @Query("SELECT p FROM Products p WHERE p.productName LIKE %:productName% " +
            "AND (:minCost IS NULL OR p.productCost >= :minCost) " +
            "AND (:maxCost IS NULL OR p.productCost <= :maxCost)")
     List<Products> findProductCostByNameAndCostRange(
             @Param("productName") String productName,
             @Param("minCost") int minCost,
             @Param("maxCost") int maxCost
     );

 }
		 

