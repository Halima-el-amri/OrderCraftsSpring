package com.joseph.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @GetMapping("/")
    public String welcome(ModelMap model) {
        return "welcome";
    }

    @GetMapping("/register")
    public String showRegistrationForm(ModelMap model) {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm(ModelMap model) {
        return "login";
    }
}
