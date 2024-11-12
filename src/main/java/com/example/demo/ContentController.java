package com.example.demo;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ContentController {

    @GetMapping ("/rejestracja")
    public String rejestracja() {
        return "rejestracja";
    }

    @GetMapping ("/logowanie")
    public String logowanie() {
        return "logowanie";
    }
}