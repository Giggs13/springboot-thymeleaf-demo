package com.giggs13.springbootthymeleafdemo.controller;

import com.giggs13.springbootthymeleafdemo.entity.Employee;
import com.giggs13.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAll());

        return "/employees/employees";
    }

    @GetMapping("/form")
    public String showForm(@RequestParam(name = "id", required = false) Integer id,
                           Model model) {
        Employee employee;
        if (id == null) {
            employee = new Employee();
        } else {
            employee = employeeService.getById(id);
        }
        model.addAttribute("employee", employee);

        return "/employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
