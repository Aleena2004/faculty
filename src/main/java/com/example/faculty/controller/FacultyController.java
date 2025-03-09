package com.example.faculty.controller;

import com.example.faculty.model.facultyModel;
import com.example.faculty.service.facultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class facultyController {

    @Autowired
    private facultyService facultyService;

    @GetMapping
    public List<facultyModel> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/{id}")
    public ResponseEntity<facultyModel> getFacultyById(@PathVariable int id) {
        Optional<facultyModel> faculty = facultyService.getFacultyById(id);
        return faculty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<facultyModel> createFaculty(@RequestBody facultyModel faculty) {
        facultyModel savedFaculty = facultyService.createFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    @PutMapping("/{id}")
    public ResponseEntity<facultyModel> updateFaculty(@PathVariable int id, @RequestBody facultyModel facultyDetails) {
        facultyModel updatedFaculty = facultyService.updateFaculty(id, facultyDetails);
        return updatedFaculty != null ? ResponseEntity.ok(updatedFaculty) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable int id) {
        boolean deleted = facultyService.deleteFaculty(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
