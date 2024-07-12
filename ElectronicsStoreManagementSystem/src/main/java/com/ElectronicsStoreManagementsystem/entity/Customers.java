package com.ElectronicsStoreManagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="customer_name" ,unique=true)
    private String customerName;

    @Column(name="customer_phone")
    private String customerPhone;
    
    @Column(name="password_number")
    private String customerPassword;
    
    @Column(name="role")
     private String role;
    public Customers() {
    }

    public Customers(String customerName, String customerPhone,String  customerPassword,String role) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerPassword= customerPassword;
        this.role=role;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }
    public String getRole() {
        return role;
    }

    public void setRole(String  role) {
        this. role =  role;
    }
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerPhone=" + customerPhone + ", customerPassword="+customerPassword+", role="+ role+"]";
    }
}
