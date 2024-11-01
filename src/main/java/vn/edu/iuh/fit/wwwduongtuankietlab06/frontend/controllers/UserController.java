package vn.edu.iuh.fit.wwwduongtuankietlab06.frontend.controllers;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import vn.edu.iuh.fit.wwwduongtuankietlab06.backend.repository.UserRepository;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserRepository userRepository;

    @GetMapping("/login-form")
    public String getLoginForm(){
        return "user/login-page";
    }

    @GetMapping("/register-form")
    public String getRegisterForm(){
        return "user/register-page";
    }

    @GetMapping("/navbar")
    public String getNavbar() {
        return "fragments/navbar.html";
    }

    @GetMapping("/right-column")
    public String getRightColumn() {
        return "fragments/right-column.html";
    }
}
