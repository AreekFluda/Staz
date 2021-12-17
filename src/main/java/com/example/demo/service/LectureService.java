package com.example.demo.service;

import com.example.demo.model.Lecture;
import com.example.demo.model.User;
import com.example.demo.repository.LectureRepository;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LectureService {
    private final LectureRepository lectureRepository;

    public List<Lecture> getAllUsers() {
        return lectureRepository.findAll();
    }

    public void deleteUserById(Long id) {
        lectureRepository.deleteById(id);
    }

    public void updateLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    public Lecture saveLecture(Lecture user) {
        return lectureRepository.save(user);
    }

    public Lecture getLectureById(Long id) {
        return lectureRepository.getById(id);
    }
}
