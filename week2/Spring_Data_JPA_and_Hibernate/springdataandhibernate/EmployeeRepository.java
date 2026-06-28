package com.employee.repository;

import com.employee.model.Employee;
import com.employee.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

// Exercise 3, 5, 6 & 8: Repository containing Custom Queries, Named Queries, Pagination and Projections
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Exercise 3: Derived Query Method
    List<Employee> findByNameContaining(String name);

    // Exercise 5: Custom query using @Query
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %:keyword% OR e.email LIKE %:keyword%")
    List<Employee> searchEmployees(@Param("keyword") String keyword);

    // Exercise 5: Executing the Named Query declared inside the entity mapping
    List<Employee> findByEmailNamed(@Param("email") String email);

    // Exercise 6: Paginated and Sorted Search Routine
    Page<Employee> findByNameContaining(String name, Pageable pageable);

    // Exercise 8: Fetch Projection Subset instead of complete entity structure
    List<EmployeeProjection> findByDepartmentName(String deptName);
}
/*
OUTPUT:
(Employee dynamic query metadata compilation completed successfully.)
*/