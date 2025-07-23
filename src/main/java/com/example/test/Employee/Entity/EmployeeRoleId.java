package com.example.test.Employee.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRoleId implements Serializable {

    @Column(name = "ypgw_id")
    private String ypgwId;

    @Column(name = "role_id")
    private String roleId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeRoleId)) return false;
        EmployeeRoleId that = (EmployeeRoleId) o;
        return Objects.equals(ypgwId, that.ypgwId) &&
                Objects.equals(roleId, that.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ypgwId, roleId);
    }
}
