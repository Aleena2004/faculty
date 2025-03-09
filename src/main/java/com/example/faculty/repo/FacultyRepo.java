package com.example.faculty.repo;

import com.example.faculty.model.facultyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface facultyRepo extends JpaRepository<facultyModel, Integer> {
}
