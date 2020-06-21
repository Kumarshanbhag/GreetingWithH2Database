package com.greeting.controller;

import com.greeting.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("/hello")
public class HelloController {
    @RequestMapping (value = {"", "/", "/home"})
    public String sayHello() {
        return "Hello World!!!";
    }

    @RequestMapping (value = {"/query"}, method = RequestMethod.GET)
    public String sayHello(@RequestParam (value = "name") String name) {
        return "Hello " + name + " !!!";
    }

    @GetMapping ("/param/{name}")
    public String sayHelloPath(@PathVariable String name) {
        return "Hello " + name + "!!!";
    }

    @PostMapping ("/post")
    public String sayHello(@RequestBody User user) {
        return "Hello " + user.getFirstName() + " " + user.getLastName() + " !!!";
    }
}
