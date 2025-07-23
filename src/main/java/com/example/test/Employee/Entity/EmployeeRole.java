package com.example.test.Employee.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRole {

    @EmbeddedId
    private EmployeeRoleId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ypgw_id", referencedColumnName = "ypgw_id", insertable = false, updatable = false)
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;
}