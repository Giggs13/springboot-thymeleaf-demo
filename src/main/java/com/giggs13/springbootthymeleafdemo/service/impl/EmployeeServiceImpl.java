package com.giggs13.springbootthymeleafdemo.service.impl;

import com.giggs13.springbootthymeleafdemo.entity.Employee;
import com.giggs13.springbootthymeleafdemo.persistence.EmployeeRepository;
import com.giggs13.springbootthymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl
        implements EmployeeService {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAllByOrderByLastName();
    }

    @Override
    public Employee getById(int id) {
        return repository.findById(id)
                .orElse(null);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
