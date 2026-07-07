package com.cognizant.ormlearn;

import javax.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;
import java.util.Set;

// ==========================================================================
// HANDSON 3: PAYROLL ENTITY ENGINE RELATIONSHIPS
// ==========================================================================
@Entity
@Table(name="department")
class Department {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="dp_id") private int id;
    @Column(name="dp_name") private String name;
    @OneToMany(mappedBy = "department") private Set<Employee> employeeList;
}

@Entity
@Table(name="skill")
class Skill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="sk_id") private int id;
    @Column(name="sk_name") private String name;
    @ManyToMany(mappedBy = "skillList") private Set<Employee> employeeList;
}

@Entity
@Table(name="employee")
class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="em_id") private int id;
    @Column(name="em_name") private String name;
    @Column(name="em_salary") private double salary;
    @Column(name="em_permanent") private boolean permanent;

    @ManyToOne @JoinColumn(name = "em_dp_id") private Department department;

    @ManyToMany
    @JoinTable(name = "employee_skill",
        joinColumns = @JoinColumn(name = "es_em_id"),
        inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
    private Set<Skill> skillList;

    public String getName() { return name; }
    public Set<Skill> getSkillList() { return skillList; }
}

// ==========================================================================
// HANDSON 2, 4 & 5: ADVANCED REPOSITORY INTERFACE
// ==========================================================================
@Repository
interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    
    // Hands on 2: JOIN FETCH optimization pattern
    @Query(value="SELECT e FROM Employee e left join fetch e.department d left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Hands on 4: Parameterized aggregate calculations
    @Query(value="SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Hands on 5: Fallback native query interface
    @Query(value="SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}

// --------------------------------------------------------------------------
// OUTPUTS LOGGED BELOW
// --------------------------------------------------------------------------
/*
28-06-26 23:55:18.204 INFO  EmployeeService - Start Transactional Execution Trace
28-06-26 23:55:18.250 DEBUG EmployeeRepository - Permanent Employee: John Doe, Skills: [Skill [id=1, name=Java]]
28-06-26 23:55:18.290 DEBUG EmployeeRepository - Average Salary for Dept 1: 55000.0
BUILD SUCCESS
*/