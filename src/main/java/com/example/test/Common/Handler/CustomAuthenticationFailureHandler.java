package com.example.test.Common.Handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        org.springframework.security.core.AuthenticationException exception)
            throws IOException, ServletException {

        String errorMessage;

        if (exception instanceof UsernameNotFoundException) {
            errorMessage = "아이디가 존재하지 않습니다.";
        } else if (exception instanceof BadCredentialsException) {
            errorMessage = "비밀번호가 일치하지 않습니다.";
        } else {
            errorMessage = "로그인에 실패했습니다.";
        }

        // 세션에 메시지 저장
        request.getSession().setAttribute("LOGIN_ERROR", errorMessage);

        // 쿼리스트링 없이 /login으로 리다이렉트
        response.sendRedirect("/login");
    }
}
