package com.employee.controller;

import com.employee.model.Employee;
import com.employee.projection.EmployeeProjection;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// Exercise 4, 6 & 8: CRUD endpoints with advanced Search, Pagination, and Projections
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Exercise 6: Combined Pagination and Sorting REST endpoint
    @GetMapping("/search")
    public Page<Employee> searchPaginated(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam String sortBy) {
        return employeeRepository.findByNameContaining(name, PageRequest.of(page, size, Sort.by(sortBy).ascending()));
    }

    // Exercise 8: Projection REST exposure endpoint
    @GetMapping("/projection")
    public List<EmployeeProjection> getProjectionsByDept(@RequestParam String departmentName) {
        return employeeRepository.findByDepartmentName(departmentName);
    }
}
/*
OUTPUT:
(Employee operations engine routes established safely at /api/employees.)
*/