package com.hogwarts.demo.service;

import com.hogwarts.demo.model.Faculty;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty getFaculty(long id);

    Faculty editFaculty(Faculty facultyUpdate);

    Faculty deleteFaculty(long id);

    List<Faculty> colorsOrNameOfFaculty(String color, String name);

    Faculty findStudents(long id);
}
