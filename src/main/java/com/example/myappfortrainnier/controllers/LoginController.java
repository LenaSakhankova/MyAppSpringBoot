package com.example.myappfortrainnier.controllers;

import com.example.myappfortrainnier.entity.UserEntity;
import com.example.myappfortrainnier.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping()
public class LoginController {
    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/adminPage")
    public List<UserEntity> showAdminPage() {
        return userService.receiveAllPeople();
    }

    @GetMapping("/hello")
    public List<UserEntity> showHelloPage() {
        return userService.receiveAllPeople();
    }
}