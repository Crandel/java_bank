package com.banktest.controllers;


import com.banktest.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class IndexController {
    @GetMapping("/test")
    public User test(@RequestParam(value="first_name", defaultValue="John") String firstName,
                     @RequestParam(value="last_name", defaultValue="John") String lastName) {
        User user = new User(firstName, lastName);
        System.out.println(user);
        return user;
    }

    @GetMapping("/index")
    public User index(@RequestParam(value="first_name", defaultValue="John") String firstName,
        @RequestParam(value="last_name", defaultValue="John") String lastName) {
        User user = new User(firstName, lastName);
        System.out.println(user);
        return user;
    }
}
