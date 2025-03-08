package com.example.faculty.controller;

import com.example.faculty.model.FacultyModel;
import com.example.faculty.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping
    public List<FacultyModel> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacultyModel> getFacultyById(@PathVariable int id) {
        Optional<FacultyModel> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<FacultyModel> createFaculty(@RequestBody FacultyModel faculty) {
        FacultyModel savedFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FacultyModel> updateFaculty(@PathVariable int id, @RequestBody FacultyModel facultyDetails) {
        FacultyModel updatedFaculty = facultyService.updateFaculty(id, facultyDetails);
        return updatedFaculty != null ? ResponseEntity.ok(updatedFaculty) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable int id) {
        boolean deleted = facultyService.deleteFaculty(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
