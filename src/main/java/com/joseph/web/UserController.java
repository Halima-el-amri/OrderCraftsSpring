package com.joseph.web;

import com.joseph.entity.User;
import com.joseph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registerForm")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

   // @GetMapping("/register")
   @RequestMapping(value = "/register",method = {RequestMethod.POST,RequestMethod.GET})
    public String registerUser(User user) {
        userService.registerUser(user);
        return "redirect:/login"; // Redirect to login page after registration
    }

    @GetMapping("/loginForm")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    //@GetMapping("/login")
    @RequestMapping(value = "/login",method = {RequestMethod.POST,RequestMethod.GET})
    public String loginUser(@RequestParam String email, @RequestParam String password) {
        User user = userService.loginUser(email, password);

        if (user != null) {
            // Successful login, you can add logic here
            return "redirect:/item/list";
        } else {
            // Failed login, redirect to the welcome page
            return "redirect:/welcome";
        }
    }


    @GetMapping("/logout")
    public String logout() {

        return "redirect:/welcome";
    }

}
