package com.example.faculty.service;

import com.example.faculty.model.facultyModel;
import com.example.faculty.repo.facultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class facultyService {

    @Autowired
    private facultyRepo facultyRepo;

    public List<facultyModel> getAllFaculties() {
        return facultyRepo.findAll();
    }

    public Optional<facultyModel> getFacultyById(int id) {
        return facultyRepo.findById(id);
    }

    public facultyModel createFaculty(facultyModel faculty) {
        return facultyRepo.save(faculty);
    }

    public facultyModel updateFaculty(int id, facultyModel facultyDetails) {
        return facultyRepo.findById(id).map(faculty -> {
            faculty.setMentorBatchId(facultyDetails.getMentorBatchId());
            faculty.setDesignationId(facultyDetails.getDesignationId());
            faculty.setDepartmentId(facultyDetails.getDepartmentId());
            faculty.setActive(facultyDetails.isActive());
            return facultyRepo.save(faculty);
        }).orElse(null);
    }

    public boolean deleteFaculty(int id) {
        if (facultyRepo.existsById(id)) {
            facultyRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
