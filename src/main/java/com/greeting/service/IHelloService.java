package com.greeting.service;

import com.greeting.model.HelloMessage;
import com.greeting.model.User;

public interface IHelloService {
    HelloMessage setMessage(User user);
}
