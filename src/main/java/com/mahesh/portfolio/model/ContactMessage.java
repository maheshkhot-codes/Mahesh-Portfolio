package com.mahesh.portfolio.model;

public class ContactMessage {

    private String name;
    private String email;
    private String message;


    // ======================================
    // DEFAULT CONSTRUCTOR
    // ======================================

    public ContactMessage() {
    }


    // ======================================
    // CONSTRUCTOR
    // ======================================

    public ContactMessage(
            String name,
            String email,
            String message) {

        this.name = name;
        this.email = email;
        this.message = message;
    }


    // ======================================
    // GETTERS
    // ======================================

    public String getName() {
        return name;
    }


    public String getEmail() {
        return email;
    }


    public String getMessage() {
        return message;
    }


    // ======================================
    // SETTERS
    // ======================================

    public void setName(String name) {
        this.name = name;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public void setMessage(String message) {
        this.message = message;
    }

}