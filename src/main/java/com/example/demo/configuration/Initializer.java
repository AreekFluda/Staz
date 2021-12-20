package com.example.demo.configuration;

import com.example.demo.model.Lecture;
import com.example.demo.model.User;
import com.example.demo.service.LectureService;
import com.example.demo.service.LogInService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.Optional;

@Component
public class Initializer {
    @Autowired
    private UserService userService;
    @Autowired
    private LectureService lectureService;
    @Autowired
    private LogInService logInService;

    public Initializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void postConstruct() {
        createUser();
    }

    public void createUser() {
        User user = createUser("Test", "test@gmail.com", "2222");
        User user1 = createUser("Test1", "test1@gmail.com", "12222");
        User user2 = createUser("Test122", "test1@gmail.com", "12222");
        logInService.saveToFile(user.getEmail());
        Lecture lecture = createLecture("Prezentacja IT", "10:00-11:45");
        Lecture lecture1 = createLecture("Prezentacja Bazy Danych", "12:00-12:45");
        Lecture lecture2 = createLecture("Prezentacja frontend", "13:00-14:45");


        userService.saveUser(user);
        userService.saveUser(user1);
        userService.saveUser(user2);
        lectureService.saveLecture(lecture);
        lectureService.saveLecture(lecture1);
        lectureService.saveLecture(lecture2);
        System.out.println(user.getId());
        System.out.println(user1.getId());
        System.out.println(user2.getId());
    }

    public User createUser(String name, String email, String password) {
        return new User(name, email, password);
    }

    public Lecture createLecture(String name, String hour) {
        return new Lecture(name, hour);
    }
}
