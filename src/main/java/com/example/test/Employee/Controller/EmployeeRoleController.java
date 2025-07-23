package com.example.test.Employee.Controller;

import com.example.test.Employee.Dto.EmployeeRoleRequestDto;
import com.example.test.Employee.Entity.EmployeeRole;
import com.example.test.Employee.Service.EmployeeRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeRoleController {

    private final EmployeeRoleService employeeRoleService;

    @PostMapping("/employeeRole")
    public ResponseEntity<List<EmployeeRole>> saveEmployeeRole(@RequestBody EmployeeRoleRequestDto request) {
        List<EmployeeRole> savedList = employeeRoleService.saveEmployeeRole(request.getYpgwId(),request.getRoleIds());
        return ResponseEntity.ok(savedList);
    }
}