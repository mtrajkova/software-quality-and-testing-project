package com.example.europa.persistance.service;

import com.example.europa.model.Research;

import java.util.List;
import java.util.Optional;

public interface ResearchService {
    void save(Research research);
    Optional<Research> findById(Long id);
    List<Research> findAll();
}
