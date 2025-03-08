package com.example.faculty.service;

import com.example.faculty.model.FacultyModel;
import com.example.faculty.repo.FacultyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepo facultyRepo;

    public List<FacultyModel> getAllFaculties() {
        return facultyRepo.findAll();
    }

    public Optional<FacultyModel> getFacultyById(int id) {
        return facultyRepo.findById(id);
    }

    public FacultyModel createFaculty(FacultyModel faculty) {
        return facultyRepo.save(faculty);
    }

    public FacultyModel updateFaculty(int id, FacultyModel facultyDetails) {
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
