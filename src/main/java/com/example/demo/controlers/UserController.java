package com.example.demo.controlers;

import com.example.demo.model.User;
import com.example.demo.service.LogInService;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final LogInService logInService;


    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        if (!userService.userExist(user.getEmail())) {
            User createdUser = userService.saveUser(user);
            return ResponseEntity.status(201).body(createdUser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(user);
    }


}

