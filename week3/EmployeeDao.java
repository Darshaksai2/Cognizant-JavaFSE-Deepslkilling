package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDao {
    private static final List<Employee> EMPLOYEE_LIST = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        Employee existing = EMPLOYEE_LIST.stream()
                .filter(e -> e.getId().equals(employee.getId()))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        
        existing.setName(employee.getName());
        existing.setSalary(employee.getSalary());
        existing.setPermanent(employee.getPermanent());
        existing.setDateOfBirth(employee.getDateOfBirth());
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        Employee existing = EMPLOYEE_LIST.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found"));
        EMPLOYEE_LIST.remove(existing);
    }
}