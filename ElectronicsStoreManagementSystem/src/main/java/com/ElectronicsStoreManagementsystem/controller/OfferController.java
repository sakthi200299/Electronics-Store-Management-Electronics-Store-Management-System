package com.ElectronicsStoreManagementsystem.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ElectronicsStoreManagementsystem.entity.Offer;
import com.ElectronicsStoreManagementsystem.service.OfferService;


import java.util.Map;

@RestController
@RequestMapping("/ElectronicsStore/offer")
public class OfferController {

	@Autowired
    private OfferService offerService;

    @GetMapping("/all")
    public ResponseEntity<Map<String, Object>> getAllOffers() {
        Map<String, Object> response = offerService.getAllOffers();
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getOfferById(@PathVariable int id) {
        Map<String, Object> response = offerService.getOfferById(id);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Map<String, Object>> createOffer(@RequestBody Offer offer) {
        Map<String, Object> response = offerService.createOffer(offer);
        if (response.get("status").equals("success")) {
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateOffer(@PathVariable int id, @RequestBody Offer updatedOffer) {
        Map<String, Object> response = offerService.updateOffer(id, updatedOffer);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteOffer(@PathVariable int id) {
        Map<String, Object> response = offerService.deleteOffer(id);
        if (response.get("status").equals("success")) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}

