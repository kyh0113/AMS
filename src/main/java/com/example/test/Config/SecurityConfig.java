package com.example.test.Config;

import com.example.test.Common.Handler.CustomAuthenticationFailureHandler;
import com.example.test.Common.Provider.CustomAuthenticationProvider;
import com.example.test.Employee.Repository.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;

    public SecurityConfig(CustomAuthenticationFailureHandler customAuthenticationFailureHandler) {
        this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           AuthenticationProvider customAuthenticationProvider) throws Exception {

        http
                .csrf(csrf -> csrf
                        .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/employee").permitAll()
                        .requestMatchers(HttpMethod.POST, "/role").permitAll()
                        .requestMatchers(HttpMethod.POST, "/employeeRole").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("ypgwId")
                        .passwordParameter("password")
                        .defaultSuccessUrl("/home", true)
                        .failureHandler(customAuthenticationFailureHandler)
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                )
                .authenticationProvider(customAuthenticationProvider); // 여기서 주입

        return http.build();
    }

    @Bean
    public AuthenticationProvider customAuthenticationProvider(EmployeeRepository employeeRepository,
                                                               PasswordEncoder passwordEncoder) {
        return new CustomAuthenticationProvider(employeeRepository, passwordEncoder);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}