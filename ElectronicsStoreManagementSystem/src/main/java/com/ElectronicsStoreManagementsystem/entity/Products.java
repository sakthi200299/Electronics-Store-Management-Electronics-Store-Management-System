package com.ElectronicsStoreManagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="product_id")
    private int productId;

    @Column(name="product_servicetag")
    private String serviceTag;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_cost")
    private int productCost;
    
    @Column(name="available")
    private int available;

    @Column(name="stock_limit")
    private int stockLimit;
     
    @Column(name="IGST_tax")
    private int igsttax;
    
    @Column(name="CGST_tax")
    private int cgsttax;
    
    @Column(name="SGST_tax")
    private int sgsttax;
    
    @Column(name="min_available")
    private int minavailable;

    public Products() {
    }

    public Products(String serviceTag, String productName, int productCost, int available, int stockLimit,int igsttax,int cgsttax,int sgsttax,int minavailable) {
        this.serviceTag = serviceTag;
        this.productName = productName;
        this.productCost = productCost;
        this.available = available;
        this.stockLimit = stockLimit;
        this.igsttax=igsttax;
        this.cgsttax=cgsttax;
        this.sgsttax=sgsttax;
        this.minavailable=minavailable;
        
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCost() {
        return productCost;
    }

    public void setProductCost(int productCost) {
        this.productCost = productCost;
    }
    
    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getStockLimit() {
        return stockLimit;
    }

    public void setStockLimit(int stockLimit) {
        this.stockLimit = stockLimit;
    }
    
    public int getIGSTtax() {
        return igsttax;
    }

    public void setIGSTtax(int igsttax) {
        this.igsttax = igsttax;
    }
    
    public int getSGSTtax() {
        return sgsttax;
    }

    public void setSGSTtax(int sgsttax) {
        this.sgsttax = sgsttax;
    }
    public int getCGSTtax() {
        return sgsttax;
    }

    public void setCGSTtax(int cgsttax) {
        this.cgsttax = cgsttax;
    }
   
    public int getMinAvailable()
    {
   	  return minavailable;
    }
     public void setMinAvailable(int minavailable)
     {
    	 this.minavailable=minavailable;
     }
    @Override
    public String toString() {
        return "Product [productId=" + productId + ", serviceTag=" + serviceTag + ", productName=" + productName + ", productCost=" + productCost + ",available=" + available + ", stockLimit=" + stockLimit + ",cgsttax="+cgsttax+",igsttax="+igsttax+",sgsttax="+sgsttax+",minavailable="+minavailable+"]";
    }
}

