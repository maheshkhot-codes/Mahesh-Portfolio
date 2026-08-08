package com.mahesh.portfolio.service;

import com.mahesh.portfolio.model.ContactMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendContactMessage(ContactMessage contact) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setTo("khotmahesh58@gmail.com");

        mail.setSubject("New Portfolio Contact Message");

        mail.setText(
            "Name: " + contact.getName() +
            "\nEmail: " + contact.getEmail() +
            "\n\nMessage:\n" + contact.getMessage()
        );

        mailSender.send(mail);
    }
}