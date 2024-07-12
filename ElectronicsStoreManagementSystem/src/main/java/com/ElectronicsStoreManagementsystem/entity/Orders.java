package com.ElectronicsStoreManagementsystem.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "order_item")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

 
    @ManyToOne(targetEntity = Customers.class)
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customers customerid;
    
    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "order_cost")
    private int orderCost;

    @Column(name = "total_quantity")
    private int totalQuantity;
    
    @Column(name = "customer_name")
    private String customerName;
    
    @Column(name = "status")
    private String status;
     

   
    // Constructors
    public Orders() {
    }

    public Orders(int orderId,Customers customerid,Timestamp orderDate, int orderCost, int totalQuantity, String customerName, String status) {
        this.orderId = orderId;
        this.customerid= customerid;
        this.orderDate = orderDate;
        this.orderCost = orderCost;
        this.totalQuantity = totalQuantity;
        this.customerName = customerName;
        this.status = status;
       
      
    }
    @PrePersist
   protected void onCreate() {
        if (this.orderDate == null) {
            this.orderDate = Timestamp.from(Instant.now());
        }
    }
    // Getters and setters
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Customers getCustomer() {
        return customerid;
    }

    public void setCustomer(Customers customerid) {
        this.customerid = customerid;
    }
    

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderCost() {
        return orderCost;
    }

    public void setOrderCost(int orderCost) {
        this.orderCost = orderCost;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
   
    @Override
    public String toString() {
    	 return "Order [orderId=" + orderId + ", customerid=" + customerid + ", orderDate=" + orderDate + ", orderCost=" + orderCost + ", totalQuantity=" + totalQuantity + ", customerName=" + customerName + ", status=" + status + "]";
    }
}

