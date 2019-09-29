package com.example.europa.persistance.service;

import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.blood.BloodType;

import java.util.List;
import java.util.Optional;

public interface BloodDonationEventService {
    List<BloodDonationEvent> findAll();
    List<BloodDonationEvent> findByBloodType(BloodType bloodType);
    Optional<BloodDonationEvent> findById(Long id);
    void save(BloodDonationEvent bloodDonationEvent);
}
