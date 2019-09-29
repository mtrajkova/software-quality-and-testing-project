package com.example.europa.persistance.service.impl;

import com.example.europa.model.Research;
import com.example.europa.persistance.repository.ResearchRepository;
import com.example.europa.persistance.service.ResearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchServiceImpl implements ResearchService {
    @Autowired
    private ResearchRepository researchRepository;

    @Override
    public void save(Research research) {
        this.researchRepository.save(research);
    }

    @Override
    public Optional<Research> findById(Long id) {
        return this.researchRepository.findById(id);
    }

    @Override
    public List<Research> findAll() {
        return this.researchRepository.findAll();
    }
}
