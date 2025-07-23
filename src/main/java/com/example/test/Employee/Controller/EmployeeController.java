package com.example.test.Employee.Controller;

import com.example.test.Employee.Dto.EmployeeRequestDto;
import com.example.test.Employee.Dto.EmployeeResponseDto;
import com.example.test.Employee.Service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/employee")
    public ResponseEntity<EmployeeResponseDto> saveEmployee(@RequestBody EmployeeRequestDto requestDto) {
        return ResponseEntity.ok(employeeService.saveEmployee(requestDto));
    }

}
