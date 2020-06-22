package com.greeting.service;

import com.greeting.model.HelloMessage;
import com.greeting.model.User;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements IHelloService {
    private static final String template = "Hello, %s!";

    @Override
    public HelloMessage setMessage(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        return new HelloMessage(String.format(template, (firstName == null || firstName.isEmpty()) ? "World"
                : (lastName == null) ? firstName
                : firstName + " " + lastName));
    }
}
