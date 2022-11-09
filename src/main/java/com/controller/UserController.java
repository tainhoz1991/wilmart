package com.controller;

import com.dto.UserDTO;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
@EnableWebMvc
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String getUsers(){
        return "index";
    }

    @GetMapping("/all")
    public String getAllUsers() throws ExecutionException, InterruptedException, IOException {
        List<UserDTO> test = service.getAllUsers();
        return test.toString();
    }

    @GetMapping("/test")
    public String test() throws ExecutionException, InterruptedException {
        Object test = service.test();
        System.out.println(test.toString());
        return test.toString();
    }
}
