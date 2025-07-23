package com.example.test.Employee.Dto;

import com.example.test.Employee.Entity.EmployeeRoleId;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeRoleRequestDto {
    private String ypgwId;
    private List<String> roleIds;
}