package com.example.test.Employee.Repository;

import com.example.test.Employee.Entity.EmployeeRole;
import com.example.test.Employee.Entity.EmployeeRoleId;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRoleRepository extends JpaRepository<EmployeeRole, EmployeeRoleId> {

}