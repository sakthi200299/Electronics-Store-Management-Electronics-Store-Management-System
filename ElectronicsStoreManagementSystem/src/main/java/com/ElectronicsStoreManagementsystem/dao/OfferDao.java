//package com.ElectronicsStoreManagementsystem.dao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.ElectronicsStoreManagementsystem.entity.Offer;
//import com.ElectronicsStoreManagementsystem.repository.OfferRepository;
//
//import java.util.List;
//@Component
//public class OfferDao {
//
//    @Autowired
//    private OfferRepository offerRepository;
//
//    public List<Offer> getAllOffers() {
//        return offerRepository.findAll();
//    }
//
//    public Offer getOfferById(int id) {
//        return offerRepository.findById(id).orElse(null);
//    }
//
//    public void createOffer(Offer offer) {
//        offerRepository.save(offer);
//    }
//
//    public Offer updateOffer(int id, Offer updatedOffer) {
//        Offer offer = offerRepository.findById(id).orElse(null);
//        if (offer != null) {
//            offer.setOfferDescription(updatedOffer.getOfferDescription());
//            offer.setoffercost(updatedOffer.getoffercost());
//            offerRepository.save(offer);
//        }
//        return offer;
//    }
//
//    public void deleteOffer(int id) {
//        offerRepository.deleteById(id);
//    }
//}
