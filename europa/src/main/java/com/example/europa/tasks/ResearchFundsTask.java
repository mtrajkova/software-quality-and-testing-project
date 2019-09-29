package com.example.europa.tasks;

import com.example.europa.persistance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class ResearchFundsTask {
    @Autowired
    private PatientService patientService;

    /*@Scheduled(cron = "0 0 0 1 1 ? *")
    public void giveFunds(){
        patientService.save(patientService.findAll()
                .stream()
                .map(p -> {
                    p.setResearchFunds(100L);
                    return p;
                })
                .collect(Collectors.toList()));
    }*/
}
