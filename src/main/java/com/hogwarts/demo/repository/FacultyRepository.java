package com.hogwarts.demo.repository;

import com.hogwarts.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    List<Faculty> findFacultyByNameOrColorIgnoreCase(String color, String name);
}
