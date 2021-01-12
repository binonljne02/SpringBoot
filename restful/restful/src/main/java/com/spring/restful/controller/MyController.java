package com.spring.restful.controller;

import java.util.List;
import java.util.Optional;

import com.spring.restful.entity.User;
import com.spring.restful.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class MyController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model){
        model.addAttribute("users", userService.getListUser());
        return "index";
    }

    @GetMapping("/{id}")
    public String getUserById(@PathVariable("id") int id,Model model){
        
        return "user";
    }

}
