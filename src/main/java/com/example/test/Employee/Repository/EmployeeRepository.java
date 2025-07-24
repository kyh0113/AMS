package com.example.test.Employee.Repository;

import com.example.test.Employee.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e " +
            "JOIN FETCH e.employeeRole er " +
            "JOIN FETCH er.role " +
            "WHERE e.ypgwId = :ypgwId")
    Optional<Employee> findByYpgwIdWithRoles(@Param("ypgwId") String ypgwId);
}
