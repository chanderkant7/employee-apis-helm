package com.example.springboot.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.app.entity.Employee;
import com.example.springboot.app.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping(value="/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(Employee employee) {
        return employeeService.createEmployee(employee);
    }

}
