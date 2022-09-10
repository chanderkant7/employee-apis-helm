package com.example.springboot.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.app.entity.Department;


public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
