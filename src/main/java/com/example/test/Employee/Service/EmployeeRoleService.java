package com.example.test.Employee.Service;

import com.example.test.Employee.Entity.EmployeeRole;
import com.example.test.Employee.Entity.EmployeeRoleId;
import com.example.test.Employee.Repository.EmployeeRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeRoleService {

    private final EmployeeRoleRepository employeeRoleRepository;

    public List<EmployeeRole> saveEmployeeRole(String ypgwId, List<String> roleIds) {
        List<EmployeeRole> savedList = new ArrayList<>();

        for (String roleId : roleIds) {
            EmployeeRoleId id = new EmployeeRoleId(ypgwId, roleId);
            EmployeeRole employeeRole = new EmployeeRole();
            employeeRole.setId(id);
            savedList.add(employeeRoleRepository.save(employeeRole));
        }

        return savedList;
    }
}