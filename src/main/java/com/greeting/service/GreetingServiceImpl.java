package com.greeting.service;

import com.greeting.model.Greeting;
import com.greeting.model.User;
import com.greeting.repository.IGreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements IGreetingService {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.getFirstName().isEmpty()) ?
                "World" : user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(new Greeting(counter.incrementAndGet(), message));
    }

    @Override
    public List<Greeting> findAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting findGreetingById(Long id) {
        return greetingRepository.findById(id).get();
    }

    @Override
    public Greeting updateGreetingsById(Long id, User user) {
        Greeting greeting = findGreetingById(id);
        greeting.setName("Hello " + user.getFirstName() + " " + user.getLastName());
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting deleteGreetingById(Long id) {
        Greeting greeting = findGreetingById(id);
        greetingRepository.delete(greeting);
        return greeting;
    }
}
