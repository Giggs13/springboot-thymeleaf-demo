package com.giggs13.springbootthymeleafdemo.controller;

import com.giggs13.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Controller
public class AppController {

    private EmployeeService employeeService;

    @Autowired
    public AppController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/greeting")
    public String greet(Model model) {
        model.addAttribute("date", LocalDateTime.now());

        return "greeting";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());

        return "employees";
    }
}
