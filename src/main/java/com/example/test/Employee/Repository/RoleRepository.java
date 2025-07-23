package com.example.test.Employee.Repository;

import com.example.test.Employee.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
