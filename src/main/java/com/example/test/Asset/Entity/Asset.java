package com.example.test.Asset.Entity;

import com.example.test.Department.Entity.Department;
import com.example.test.Employee.Entity.Employee;
import jakarta.persistence.*;

@Entity
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String assetName; // 비품 이름

    @Column(unique = true)  // nullable 설정 생략 = 기본값 true
    private String assetCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department; // 해당 비품이 어느 부서에 있는지

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assigned_employee_id")
    private Employee assignedEmployee; // 해당 비품을 할당받은 사용자가 누구인지
}
