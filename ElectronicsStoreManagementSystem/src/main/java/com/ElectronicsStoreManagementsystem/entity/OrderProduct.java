package com.ElectronicsStoreManagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="order_product")
public class OrderProduct {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="order_product_id")
    private int orderProductId;

    @ManyToOne(targetEntity = Orders.class)
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Orders orderId;
 

    @ManyToOne(targetEntity = Products.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Products productId;

    @Column(name="product_quantity")
    private int productQuantity;

    @Column(name="product_cost")
    private int productCost;

    @Column(name="item_name")
    private String itemName;

    public OrderProduct() {
    }

    public OrderProduct(Orders orderId,Products productId, int productQuantity, int productCost, String itemName) {
        this.orderId = orderId;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.productCost = productCost;
        this.itemName = itemName;
    }

    public int getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Orders getOrderId() {
        return orderId;
    }

    public void setOrderId(Orders orderId) {
        this.orderId = orderId;
    }

    public Products getProductId() {
        return productId;
    }

    public void setProductId(Products productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public String toString() {
        return "OrderProduct [orderProductId=" + orderProductId + ", orderId=" + orderId + ", productId=" + productId
                + ", productQuantity=" + productQuantity + ", productCost=" + productCost + ", itemName=" + itemName
                + "]";
    }
}