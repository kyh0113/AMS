package com.example.test.Employee.Controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginForm(HttpServletRequest request, Model model) {
        // 세션에서 에러 메시지 꺼내기
        String errorMessage = (String) request.getSession().getAttribute("LOGIN_ERROR");

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            request.getSession().removeAttribute("LOGIN_ERROR"); // 메시지 제거 (1회용)
        }

        return "login"; // 로그인 페이지로 이동
    }
}
