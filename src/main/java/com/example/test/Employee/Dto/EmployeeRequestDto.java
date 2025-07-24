package com.example.test.Employee.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequestDto {
    private String ypgwId;
    private String name;
    private String password;
    private String departmentName;
}