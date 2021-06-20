package com.codeup.springblog.controllers;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UsersController {

    @GetMapping("/users/all")
    public String getAllUsers(Model model) {
        List<User> users = new ArrayList<>();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user")
    public String getUserString(Model model) {
        return "users";
    }
}
