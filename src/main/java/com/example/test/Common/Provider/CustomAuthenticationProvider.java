package com.example.test.Common.Provider;

import com.example.test.Employee.Entity.Employee;
import com.example.test.Employee.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomAuthenticationProvider implements AuthenticationProvider { // 로그인 아이디/비밀번호를 직접 검증

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String ypgwId = authentication.getName();
        String rawPassword = authentication.getCredentials().toString();

        Employee employee = employeeRepository.findByYpgwIdWithRoles(ypgwId)
                .orElseThrow(() -> new UsernameNotFoundException("아이디가 존재하지 않습니다."));

        if (!passwordEncoder.matches(rawPassword, employee.getPassword())) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return new UsernamePasswordAuthenticationToken(
                employee, // principal 객체
                null, // password는 인증 후 null 처리
                employee.getEmployeeRole().stream()
                        .map(er -> new SimpleGrantedAuthority("ROLE_" + er.getRole().getRoleId()))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}