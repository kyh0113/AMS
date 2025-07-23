package com.example.test.Employee.Service;

import com.example.test.Employee.Entity.Role;
import com.example.test.Employee.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role save(Role role){
        return roleRepository.save(role);
    }
}
