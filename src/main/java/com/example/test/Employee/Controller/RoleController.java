package com.example.test.Employee.Controller;

import com.example.test.Employee.Entity.Role;
import com.example.test.Employee.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<Role> saveRole(@RequestBody Role role){
        Role saved = roleService.save(role);
        return ResponseEntity.ok(saved);
    }
}
