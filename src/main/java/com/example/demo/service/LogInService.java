package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    public void saveToFile(String email) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dateToFile = formatter.format(date);
        String text = "Account was created correctly";
        File myObj = new File("src/main/powiadomienia.txt");
        try {
            FileWriter fileWriter = new FileWriter(myObj);
            fileWriter.write(dateToFile + '\n');
            fileWriter.write(email + '\n');
            fileWriter.write(text + "\n");
            fileWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("Error occured" + e.getMessage());
        }

    }
}
