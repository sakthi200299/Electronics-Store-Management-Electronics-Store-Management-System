package com.ElectronicsStoreManagementsystem.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ElectronicsStoreManagementsystem.entity.Offer;
import com.ElectronicsStoreManagementsystem.repository.OfferRepository;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OfferService {


    @Autowired
    private OfferRepository offerRepository;

    public Map<String, Object> getAllOffers() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<Offer> offers = offerRepository.findAll();
            response.put("status", "success");
            response.put("offers", offers);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> getOfferById(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            Offer offer = offerRepository.findById(id).orElse(null);
            response.put("status", "success");
            response.put("offer", offer);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", e.getMessage());
        }
        return response;
    }

    public Map<String, Object> createOffer(Offer offer) {
        Map<String, Object> response = new HashMap<>();
        try {
            offerRepository.save(offer);
            response.put("status", "success");
            response.put("message", "Offer created successfully");
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "Failed to create offer: " + e.getMessage());
        }
        return response;
    }

    public Map<String, Object> updateOffer(int id, Offer updatedOffer) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (offerRepository.existsById(id)) {
                Offer existingOffer = offerRepository.findById(id).orElse(null);
                if (existingOffer != null) {
                    existingOffer.setOfferDescription(updatedOffer.getOfferDescription());
                    existingOffer.setoffercost(updatedOffer.getoffercost());
                    offerRepository.save(existingOffer);
                    response.put("status", "success");
                    response.put("message", "Offer updated successfully");
                } else {
                    response.put("status", "error");
                    response.put("message", "Offer not found");
                }
            } else {
                response.put("status", "error");
                response.put("message", "Offer not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "Failed to update offer: " + e.getMessage());
        }
        return response;
    }

    public Map<String, Object> deleteOffer(int id) {
        Map<String, Object> response = new HashMap<>();
        try {
            if (offerRepository.existsById(id)) {
                offerRepository.deleteById(id);
                response.put("status", "success");
                response.put("message", "Offer deleted successfully");
            } else {
                response.put("status", "error");
                response.put("message", "Offer not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.put("status", "error");
            response.put("message", "Failed to delete offer: " + e.getMessage());
        }
        return response;
    }
}
