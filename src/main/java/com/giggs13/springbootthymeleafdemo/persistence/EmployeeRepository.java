package com.giggs13.springbootthymeleafdemo.persistence;

import com.giggs13.springbootthymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByOrderByLastName();
}
