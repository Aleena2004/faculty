package com.example.faculty.repo;

import com.example.faculty.model.FacultyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepo extends JpaRepository<FacultyModel, Integer> {
}
