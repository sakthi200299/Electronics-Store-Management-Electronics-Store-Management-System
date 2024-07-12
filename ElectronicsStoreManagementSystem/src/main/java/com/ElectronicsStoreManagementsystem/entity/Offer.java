package com.ElectronicsStoreManagementsystem.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id")
    private int offerId;

    @Column(name = "offer_description")
    private String offerDescription;


    @Column(name= "offer_cost")
    private int offercost;

    // Constructors, getters, and setters

    public Offer() {}

    public Offer(String offerDescription, int offercost) {
        this.offerDescription = offerDescription;
        this.offercost = offercost;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public int getoffercost() {
        return offercost;
    }

    public void setoffercost(int offercost) {
        this.offercost = offercost;
    }
     @Override
        public String toString() 
     {
            return "Offer [offerId=" + offerId + ", offerDescription=" + offerDescription + ", offercost=" + offercost + "]";
        }

    
}
