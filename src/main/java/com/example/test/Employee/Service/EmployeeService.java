package com.example.test.Employee.Service;

import com.example.test.Employee.Dto.EmployeeRequestDto;
import com.example.test.Employee.Dto.EmployeeResponseDto;
import com.example.test.Employee.Entity.Employee;
import com.example.test.Employee.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    public EmployeeResponseDto saveEmployee(EmployeeRequestDto dto) {
        Employee employee = new Employee();
        employee.setYpgwId(dto.getYpgwId());
        employee.setName(dto.getName());
        employee.setPassword(passwordEncoder.encode(dto.getPassword()));

        Employee saved = employeeRepository.save(employee);
        return new EmployeeResponseDto(saved.getYpgwId(), saved.getName());
    }

}
