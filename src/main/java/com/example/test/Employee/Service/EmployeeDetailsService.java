package com.example.test.Employee.Service;

import com.example.test.Employee.Entity.Employee;
import com.example.test.Employee.Repository.EmployeeRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional(readOnly = true)
public class EmployeeDetailsService implements UserDetailsService {

    private final EmployeeRepository employeeRepository;

    public EmployeeDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String ypgwId) throws UsernameNotFoundException {

        Employee user = employeeRepository.findByYpgwIdWithRoles(ypgwId)
                .orElseThrow(() -> {
                    return new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
                });

        List<GrantedAuthority> authorities = user.getEmployeeRole().stream()
                .map(er -> new SimpleGrantedAuthority("ROLE_" + er.getRole().getRoleId()))
                .collect(Collectors.toList());
        return new User(user.getYpgwId(), user.getPassword(), authorities);
    } // return 값은 Spring Security 내부로 전달돼서 인증(Authentication) 과정에 사용
}