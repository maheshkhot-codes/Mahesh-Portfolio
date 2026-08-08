package com.mahesh.portfolio.service;

import com.mahesh.portfolio.model.ContactMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Value("${resend.api.key}")
    private String resendApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendContactMessage(ContactMessage contact) {

        String url = "https://api.resend.com/emails";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(resendApiKey);

        Map<String, Object> body = new HashMap<>();

        body.put("from", "Portfolio <onboarding@resend.dev>");
        body.put("to", new String[]{"khotmahesh58@gmail.com"});
        body.put("subject", "New Portfolio Contact Message");

        body.put("text",
                "Name: " + contact.getName() +
                "\nEmail: " + contact.getEmail() +
                "\n\nMessage:\n" + contact.getMessage()
        );

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException(
                    "Failed to send email: " + response.getBody()
            );
        }
    }
}