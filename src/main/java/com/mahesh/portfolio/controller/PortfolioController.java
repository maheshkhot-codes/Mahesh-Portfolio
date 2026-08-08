package com.mahesh.portfolio.controller;

import com.mahesh.portfolio.model.ContactMessage;
import com.mahesh.portfolio.service.EmailService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

@Controller
public class PortfolioController {

    private final EmailService emailService;

    public PortfolioController(EmailService emailService) {
        this.emailService = emailService;
    }

    /**
     * Loads the portfolio home page.
     */
    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("name", "Mahesh Khot");
        model.addAttribute("role", "Software Engineer");

        return "index";
    }

    /**
     * Receives contact form messages and sends them by email.
     */
    @PostMapping("/api/contact")
    @ResponseBody
    public ResponseEntity<String> sendMessage(
            @RequestBody ContactMessage contactMessage) {

        try {

            emailService.sendContactMessage(contactMessage);

            return ResponseEntity.ok("Message sent successfully");

        } catch (Exception e) {

            e.printStackTrace();

            return ResponseEntity
                    .internalServerError()
                    .body("Failed to send message");
        }
    }
}