package com.hogwarts.demo.repository;

import com.hogwarts.demo.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

}
