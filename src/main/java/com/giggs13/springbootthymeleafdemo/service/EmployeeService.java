package com.giggs13.springbootthymeleafdemo.service;

import com.giggs13.springbootthymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    void save(Employee employee);

    void delete(int id);
}
