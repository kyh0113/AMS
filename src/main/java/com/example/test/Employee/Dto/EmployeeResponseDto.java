package com.example.test.Employee.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EmployeeResponseDto {
    private String ypgwId;
    private String name;
    // 일부러 패스워드는 안보려고 뺌
}