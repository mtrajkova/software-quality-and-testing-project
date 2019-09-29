package com.example.europa.persistance.repository;

import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.blood.BloodType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodDonationEventRepository extends JpaRepository<BloodDonationEvent, Long> {
    List<BloodDonationEvent> findByBloodType(BloodType bloodType);
}
