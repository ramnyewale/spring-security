package com.spring.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NoticesController {

    @GetMapping("/notice")
    public String getAccountDetails(){
        return "Welcome to Notice Section!";
    }
}
