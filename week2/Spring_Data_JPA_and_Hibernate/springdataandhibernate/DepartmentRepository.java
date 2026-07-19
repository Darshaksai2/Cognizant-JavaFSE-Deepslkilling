package com.employee.repository;

import com.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Exercise 3: Department Repository Layer
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
/*
OUTPUT:
(Department infrastructure storage mapping loaded.)
*/