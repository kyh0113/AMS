package com.example.test.Employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "role")
@Getter
@Setter
public class Role {

    @Id
    @Column(name = "role_id")
    private String roleId; // 'ADMIN', 'USER' 등

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

}
