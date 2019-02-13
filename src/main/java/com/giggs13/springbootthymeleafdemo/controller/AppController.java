package com.giggs13.springbootthymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class AppController {

    @GetMapping("/greeting")
    public String greet(Model model) {
        model.addAttribute("date", LocalDateTime.now());

        return "greeting";
    }
}
