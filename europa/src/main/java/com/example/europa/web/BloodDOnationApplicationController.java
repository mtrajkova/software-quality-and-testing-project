package com.example.europa.web;

import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodDonationApplication;
import com.example.europa.persistance.service.BloodDonationApplicationService;
import com.example.europa.persistance.service.EmailService;
import com.example.europa.persistance.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/blood/donation/applications")
public class BloodDOnationApplicationController {
    @Autowired
    private BloodDonationApplicationService bloodDonationApplicationService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/all")
    public List<BloodDonationApplication> getAll() {
        return this.bloodDonationApplicationService.findAll();
    }

    @GetMapping("/approve")
    public List<BloodDonationApplication> approve(@RequestParam Long id) throws UnsupportedEncodingException, AddressException {
        BloodDonationApplication bda = this.bloodDonationApplicationService.findById(id).get();
        Patient patient = bda.getPatient();
        patient.setPoints(patient.getPoints() + 500);
        this.patientService.save(patient);
        this.bloodDonationApplicationService.delete(bda);
        this.emailService.send(patient);
        return this.bloodDonationApplicationService.findAll();
    }

    @GetMapping("/decline")
    public List<BloodDonationApplication> decline(@RequestParam Long id){
        BloodDonationApplication bda = this.bloodDonationApplicationService.findById(id).get();
        this.bloodDonationApplicationService.delete(bda);

        return this.bloodDonationApplicationService.findAll();
    }

}
