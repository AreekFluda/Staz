package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogInService {
    private final UserRepository userRepository;

    @Transactional
    public Optional<User> getExact(String name, String email, String password) {
        return userRepository.findByNameAndEmailAndPassword(name, email, password);
    }

    public boolean userExist(User user) {
        return getExact(user.getName(), user.getEmail(), user.getPassword()).isPresent();
    }
}
