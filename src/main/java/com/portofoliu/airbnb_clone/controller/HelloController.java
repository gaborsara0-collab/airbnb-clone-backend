package com.portofoliu.airbnb_clone.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/api/test")
    public String testEndpoint() {
        return "Salut! Backend-ul meu Spring Boot funcționează perfect.";
    }
}