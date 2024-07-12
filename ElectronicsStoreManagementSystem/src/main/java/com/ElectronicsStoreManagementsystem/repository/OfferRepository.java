package com.ElectronicsStoreManagementsystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ElectronicsStoreManagementsystem.entity.Offer;
public interface OfferRepository extends JpaRepository<Offer, Integer>
{
}
