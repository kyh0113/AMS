package com.example.test.Employee.Service;

import com.example.test.Department.Entity.Department;
import com.example.test.Department.Repository.DepartmentRepository;
import com.example.test.Employee.Dto.EmployeeRequestDto;
import com.example.test.Employee.Dto.EmployeeResponseDto;
import com.example.test.Employee.Entity.Employee;
import com.example.test.Employee.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeResponseDto saveEmployee(EmployeeRequestDto dto) {

        Department department = departmentRepository.findByDepartmentName(dto.getDepartmentName())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 부서입니다: "+ dto.getDepartmentName()));
        Employee employee = new Employee();
        employee.setYpgwId(dto.getYpgwId());
        employee.setName(dto.getName());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));
        employee.setDepartment(department);

        Employee saved = employeeRepository.save(employee);
        return new EmployeeResponseDto(saved.getYpgwId(), saved.getName());
    }
}
