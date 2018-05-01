package com.banktest.controllers;


import com.banktest.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class IndexController {
    @GetMapping("/test")
    public String test(@RequestParam(value="first_name", defaultValue="John") String firstName,
                     @RequestParam(value="last_name", defaultValue="Lennon") String lastName) {
        User user = new User(firstName, lastName);
        System.out.println(user);
        return user.toString();
    }

    @GetMapping("/index")
    public String index(@RequestParam(value="first_name", defaultValue="John") String firstName,
                      @RequestParam(value="last_name", defaultValue="Lennon") String lastName) {
        User user = new User(firstName, lastName);
        System.out.println(user);
        return user.toString();
    }
}
