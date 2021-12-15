package com.example.demo.configuration;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;

@Component
public class Initializer {
    @Autowired
    private UserService userService;

    public Initializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct() {
        createUser();
    }

    public void createUser() {
        User user = createUser("Test", "test@", "2222");
        User user1 = createUser("Test1", "test1@", "12222");
        userService.saveUser(user);
        userService.saveUser(user1);

    }

    public User createUser(String name, String email, String password) {
        return new User(name, email, password);
    }
}
