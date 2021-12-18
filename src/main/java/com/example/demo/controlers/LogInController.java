package com.example.demo.controlers;

import com.example.demo.model.User;
import com.example.demo.service.LogInService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LogInController {
    private final LogInService logInService;

    @PostMapping
    public ResponseEntity<User> getExactUser(@RequestBody User user) {
        if (logInService.userExist(user)) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(user);
        }

    }
}
