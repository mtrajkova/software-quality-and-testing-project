package com.example.europa.web;

import com.example.europa.model.Patient;
import com.example.europa.model.Research;
import com.example.europa.model.pojo.ResearchFundingPojo;
import com.example.europa.persistance.service.PatientService;
import com.example.europa.persistance.service.ResearchService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/researches")
public class ResearchController {
    private PatientService patientService;
    private ResearchService researchService;

    public ResearchController(PatientService patientService, ResearchService researchService) {
        this.patientService = patientService;
        this.researchService = researchService;
    }

    @GetMapping("/all")
    public List<Research> getAll(){
        return this.researchService.findAll();
    }

    @PostMapping("/fund")
    public Map<String, String> fundResearch(@RequestBody ResearchFundingPojo rfp){

        Long funds = Long.parseLong(rfp.getFunds());
        Patient patient = this.patientService.findByPersonalId(rfp.getPersonalId()).get();
        Research research = this.researchService.findById(Long.parseLong(rfp.getResearchId())).get();
        String message = "";

        if(patient.getResearchFunds() >= funds){
            patient.setResearchFunds(patient.getResearchFunds() - funds);
            research.setCurrentBudget(research.getCurrentBudget() + funds);
            message = "Successful funding";
            patientService.save(patient);
            researchService.save(research);
        }else{
            message = "Insufficient amount of funds";
        }

        return Collections.singletonMap("response", message);
    }
}
