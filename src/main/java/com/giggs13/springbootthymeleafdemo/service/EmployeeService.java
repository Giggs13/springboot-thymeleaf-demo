package com.giggs13.springbootthymeleafdemo.service;

import com.giggs13.springbootthymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();
}
