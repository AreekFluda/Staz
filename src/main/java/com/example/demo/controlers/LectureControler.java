package com.example.demo.controlers;

import com.example.demo.model.Lecture;
import com.example.demo.model.User;
import com.example.demo.service.LectureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/lecture")
public class LectureControler {
    private final LectureService lectureService;

    @GetMapping
    public ResponseEntity<List<Lecture>> getLectures() {
        List<Lecture> lectureList = lectureService.getAllUsers();
        return ResponseEntity.ok(lectureList);
    }

    @PostMapping
    public ResponseEntity<Lecture> addLecture(@RequestBody Lecture lecture) {
        Lecture createdLecture = lectureService.saveLecture(lecture);
        return ResponseEntity.status(201).body(createdLecture);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Lecture> deleteLecture(@PathVariable Long id) {
        lectureService.deleteUserById(id);
        return ResponseEntity.ok(lectureService.getLectureById(id));
    }

    @PutMapping
    public ResponseEntity<Lecture> updateLecture(@RequestBody Lecture lecture) {
        lectureService.updateLecture(lectureService.saveLecture(lecture));
        return ResponseEntity.ok(lecture);
    }

}
