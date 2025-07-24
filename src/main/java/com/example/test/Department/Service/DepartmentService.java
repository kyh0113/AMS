package com.example.test.Department.Service;

import com.example.test.Department.Entity.Department;
import com.example.test.Department.Repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public Department saveDepartment(String departmentName) {
        // 중복 체크
        if (departmentRepository.findByDepartmentName(departmentName).isPresent()) {
            throw new IllegalArgumentException("이미 존재하는 부서입니다: " + departmentName);
        }
        Department department = Department.builder()
                .departmentName(departmentName)
                .build();
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
