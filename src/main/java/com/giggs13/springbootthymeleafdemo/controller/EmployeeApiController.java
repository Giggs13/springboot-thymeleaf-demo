package com.giggs13.springbootthymeleafdemo.controller;

import com.giggs13.springbootthymeleafdemo.entity.CreatedResourceIdResponse;
import com.giggs13.springbootthymeleafdemo.entity.Employee;
import com.giggs13.springbootthymeleafdemo.service.EmployeeService;
import com.giggs13.springbootthymeleafdemo.util.RestPreconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeApiController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Employee> getAll() {
        return employeeService.getAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Employee getById(@PathVariable int id) {
        return RestPreconditions.checkFound(employeeService.getById(id), "Employee not found by id " + id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedResourceIdResponse create(@RequestBody Employee employee) {
        employee.setId(0);
        employeeService.save(employee);

        return new CreatedResourceIdResponse(employee.getId());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable int id) {
        RestPreconditions.checkFound(employeeService.getById(id), "Employee not found by id " + id);
        employeeService.delete(id);
    }
}
