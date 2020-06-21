package com.greeting.controller;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    @Autowired
    IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "firstName") String fName,
                             @RequestParam(value = "lastName") String lName) {
        User user =new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/greeting/{fName}")
    public Greeting greetingUsingPath(@PathVariable String fName,
                             @RequestParam(value = "lastName") String lName) {
        User user =new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.addGreeting(user);
    }
}