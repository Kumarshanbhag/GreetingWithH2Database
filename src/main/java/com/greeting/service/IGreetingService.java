package com.greeting.service;

import com.greeting.model.Greeting;
import com.greeting.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);

    List<Greeting> findAllGreetings();
}
