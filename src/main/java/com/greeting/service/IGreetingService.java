package com.greeting.service;

import com.greeting.model.Greeting;
import com.greeting.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
}
