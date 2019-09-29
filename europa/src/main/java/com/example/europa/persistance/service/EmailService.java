package com.example.europa.persistance.service;

import com.example.europa.model.Patient;
import com.example.europa.model.blood.BloodDonationEvent;

import javax.mail.internet.AddressException;
import java.io.UnsupportedEncodingException;

public interface EmailService {
    void send(BloodDonationEvent event) throws UnsupportedEncodingException;
    void send(Patient patient) throws AddressException, UnsupportedEncodingException;
}
