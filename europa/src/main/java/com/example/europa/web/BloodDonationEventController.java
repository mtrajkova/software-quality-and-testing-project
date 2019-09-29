package com.example.europa.web;

import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodDonationApplication;
import com.example.europa.model.blood.BloodDonationEvent;
import com.example.europa.model.pojo.BloodDonationApplicationPojo;
import com.example.europa.model.pojo.BloodDonationEventPojo;
import com.example.europa.persistance.service.*;
import com.example.europa.utils.LocalDateTimeToStringConverter;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/blood/donation/events")
public class BloodDonationEventController {
    private BloodDonationEventService bloodDonationEventService;
    private BloodTypeService bloodTypeService;
    private EmailService emailService;
    private BloodDonationApplicationService bloodDonationApplicationService;
    private PatientService patientService;

    public BloodDonationEventController(BloodDonationEventService bloodDonationEventService, BloodTypeService bloodTypeService, EmailService emailService, BloodDonationApplicationService bloodDonationApplicationService, PatientService patientService) {
        this.bloodDonationEventService = bloodDonationEventService;
        this.bloodTypeService = bloodTypeService;
        this.emailService = emailService;
        this.bloodDonationApplicationService = bloodDonationApplicationService;
        this.patientService = patientService;
    }

    @GetMapping("/all")
    public List<BloodDonationEvent> getAllEvents(@RequestParam String personalId){
            Patient patient = this.patientService.findByPersonalId(personalId).get();
        List<BloodDonationEvent> events = this.bloodDonationEventService.findByBloodType(patient.getBloodType());
        return events;
    }

    @PostMapping(value = "/create")
    public String createEvent(@RequestBody BloodDonationEventPojo event) throws UnsupportedEncodingException {
        BloodDonationEvent bloodDonationEvent = new BloodDonationEvent();
        bloodDonationEvent.setBloodType(this.bloodTypeService.findByType(event.getBloodType()).get());
        bloodDonationEvent.setName(event.getName());
        bloodDonationEvent.setPhoneNumber(event.getPhoneNumber());
        bloodDonationEvent.setDescription(event.getDescription());
        bloodDonationEvent.setDateCreated(LocalDateTimeToStringConverter.convert(LocalDateTime.now()));

        this.bloodDonationEventService.save(bloodDonationEvent);

        this.emailService.send(bloodDonationEvent);

        return "success";
    }

    @PostMapping(value = "/apply")
    public Patient createEvent(@RequestBody BloodDonationApplicationPojo bdap){
        BloodDonationApplication bda = new BloodDonationApplication();
        bda.setEventId(Long.parseLong(bdap.getEventId()));
        bda.setPersonalId(bdap.getPersonalId());
        bda.setPatient(this.patientService.findByPersonalId(bdap.getPersonalId()).get());
        bda.setEvent(this.bloodDonationEventService.findById(bda.getEventId()).get());
        this.bloodDonationApplicationService.save(bda);

        return this.patientService.findByPersonalId(bdap.getPersonalId()).get();
    }

    @GetMapping(value = "/{id}")
    public BloodDonationEvent getEvent(@PathVariable Long id){
        return this.bloodDonationEventService.findById(id).get();
    }
}
