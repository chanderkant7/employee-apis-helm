package com.example.springboot.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.app.entity.Employee;


public interface  EmployeeRepository extends JpaRepository<Employee,Integer> {
}
