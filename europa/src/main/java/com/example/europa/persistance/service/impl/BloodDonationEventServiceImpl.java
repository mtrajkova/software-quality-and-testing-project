package com.example.europa.persistance.service.impl;

import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.blood.BloodType;
import com.example.europa.model.blood.BloodTypeGives;
import com.example.europa.persistance.repository.BloodDonationEventRepository;
import com.example.europa.persistance.service.BloodDonationEventService;
import com.example.europa.persistance.service.BloodTypeGivesService;
import com.example.europa.persistance.service.BloodTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BloodDonationEventServiceImpl implements BloodDonationEventService {
    @Autowired
    private BloodDonationEventRepository bloodDonationEventRepository;
    @Autowired
    private BloodTypeGivesService bloodTypeGivesService;
    @Autowired
    private BloodTypeService bloodTypeService;

    @Override
    public List<BloodDonationEvent> findAll() {
        return this.bloodDonationEventRepository.findAll();
    }

    @Override
    public List<BloodDonationEvent> findByBloodType(BloodType bloodType) {
        List<BloodTypeGives> donatorGroups = this.bloodTypeGivesService.findByGivesType(bloodType.getType());
        List<BloodType> qualifiedGroups = donatorGroups
                .stream()
                .map(btg -> this.bloodTypeService.findByType(btg.getReceivesType()).get())
                .collect(Collectors.toList());

        List<BloodDonationEvent> events = qualifiedGroups
                .stream()
                .map(bde -> this.bloodDonationEventRepository.findByBloodType(bde))
                .flatMap(List::stream)
                .collect(Collectors.toList());

        return events;
    }

    @Override
    public Optional<BloodDonationEvent> findById(Long id) {
        return this.bloodDonationEventRepository.findById(id);
    }

    @Override
    public void save(BloodDonationEvent bloodDonationEvent) {
        this.bloodDonationEventRepository.save(bloodDonationEvent);
    }
}
