package com.greeting.controller;

import com.greeting.model.HelloMessage;
import com.greeting.model.User;
import com.greeting.service.IHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/hello")
public class HelloController {
    User user = new User();

    @Autowired
    IHelloService helloService;

    @RequestMapping (value = {"", "/", "/home"})
    public HelloMessage sayHello() {
        return helloService.setMessage(user);
    }

    @RequestMapping (value = {"/query"}, method = RequestMethod.GET)
    public HelloMessage sayHello(@RequestParam (value = "name") String name) {
        user.setFirstName(name);
        return helloService.setMessage(user);
    }

    @GetMapping ("/param/{name}")
    public HelloMessage sayHelloPath(@PathVariable String name) {
        user.setFirstName(name);
        return helloService.setMessage(user);
    }

    @PostMapping ("/post")
    public HelloMessage sayHello(@RequestBody User user) {
        return helloService.setMessage(user);
    }

    @PutMapping ("/put/{firstName}")
    public HelloMessage sayHello(@PathVariable String firstName, @RequestParam (value = "lastName") String lastName) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return helloService.setMessage(user);
    }
}
