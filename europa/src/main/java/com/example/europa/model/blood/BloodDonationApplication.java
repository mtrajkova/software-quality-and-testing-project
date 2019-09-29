package com.example.europa.model.blood;

import com.example.europa.model.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "BLOOD_DONATION_APPLICATION")
public class BloodDonationApplication {
    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnore
    @Column(name = "PERSONAL_ID")
    private String personalId;;

    @JsonIgnore
    @Column(name = "EVENT_ID")
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "PATIENT")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "EVENT")
    private BloodDonationEvent event;

    public BloodDonationApplication() {
    }

    public BloodDonationApplication(String personalId, Long eventId, Patient patient, BloodDonationEvent event) {
        this.personalId = personalId;
        this.eventId = eventId;
        this.patient = patient;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public BloodDonationEvent getEvent() {
        return event;
    }

    public void setEvent(BloodDonationEvent event) {
        this.event = event;
    }
}
