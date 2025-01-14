package com.hogwarts.demo.service;

import com.hogwarts.demo.model.Faculty;

public interface FacultyService {

    Faculty addFaculty(Faculty faculty);

    Faculty getFaculty(long id);

    Faculty editFaculty(Faculty facultyUpdate);

    Faculty deleteFaculty(long id);
}
