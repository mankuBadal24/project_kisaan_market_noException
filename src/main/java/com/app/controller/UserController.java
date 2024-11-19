package com.app.controller;

import com.app.model.UserDtls;
import com.app.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody UserDtls user) {
        userService.registerUser(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDtls userDtls) {
        UserDtls user = userService.login(userDtls.getPhoneNumber(), userDtls.getPassword());
        if (user != null) {
            return "Login successful! Welcome, " + user.getName();
        }
        return "Invalid phone number or password.";
    }

}
