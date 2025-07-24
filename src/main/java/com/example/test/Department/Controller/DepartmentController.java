package com.example.test.Department.Controller;

import com.example.test.Department.Dto.DepartmentRequestDto;
import com.example.test.Department.Entity.Department;
import com.example.test.Department.Repository.DepartmentRepository;
import com.example.test.Department.Service.DepartmentService;
import com.example.test.Employee.Entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody DepartmentRequestDto requestDto){
        Department saved = departmentService.saveDepartment(requestDto.getDepartmentName());
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public List<Department> getDepartments() {
        return departmentService.getAllDepartments();
    }
}