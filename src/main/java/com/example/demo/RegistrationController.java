package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private AppUserRepository appUserRepository;

    @PostMapping(value = "/rejestracja", consumes = "application/json")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserRepository.save(appUser);
    }
}