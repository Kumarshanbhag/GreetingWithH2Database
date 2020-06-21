package com.greeting.controller;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {
    @Autowired
    IGreetingService greetingService;

    @GetMapping ("/greeting")
    public Greeting greeting(@RequestParam (value = "firstName") String fName,
                             @RequestParam (value = "lastName") String lName) {
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.addGreeting(user);
    }

    @GetMapping ("/greeting/{fName}")
    public Greeting greetingUsingPath(@PathVariable String fName,
                                      @RequestParam (value = "lastName") String lName) {
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.addGreeting(user);
    }

    @GetMapping ("/findallgreeting")
    public List<Greeting> getAllGreeting() {
        return greetingService.findAllGreetings();
    }

    @GetMapping ("/findgreetingbyid/{id}")
    public Greeting getGreetingByIdUSingPath(@PathVariable Long id) {
        return greetingService.findGreetingById(id);
    }

    @GetMapping ("/findgreetingbyid")
    public Greeting getGreetingById(@RequestParam (value = "id") Long id) {
        return greetingService.findGreetingById(id);
    }

    @PutMapping ("/update/{id}")
    public Greeting updateGreeting(@PathVariable Long id,
                                   @RequestParam (value = "firstName") String fName,
                                   @RequestParam (value = "lastName") String lName) {
        User user = new User();
        user.setFirstName(fName);
        user.setLastName(lName);
        return greetingService.updateGreetingsById(id, user);
    }

    @PutMapping ("/update")
    public Greeting updateGreetingByBody(@RequestParam (value = "id") Long id,
                                         @RequestBody User user) {
        return greetingService.updateGreetingsById(id, user);
    }

    @DeleteMapping("/delete/{id}")
    public Greeting deleteUserById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }
}