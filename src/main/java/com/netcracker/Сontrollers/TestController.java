package com.netcracker.Сontrollers;

import com.netcracker.Model.User;
import com.netcracker.Services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private UserService userService;

    TestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User testGet(@PathVariable Long id) {
        return userService.getUser(id);
    }
}
