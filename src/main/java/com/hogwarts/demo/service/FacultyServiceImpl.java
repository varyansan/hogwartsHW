package com.hogwarts.demo.service;

import com.hogwarts.demo.exception.FacultyNotFoundException;
import com.hogwarts.demo.model.Faculty;
import com.hogwarts.demo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyServiceImpl {

    @Autowired
    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
    }

    public Faculty editFaculty(Faculty facultyUpdate) {
        if (!facultyRepository.existsById(facultyUpdate.getId())) {
            throw new FacultyNotFoundException(facultyUpdate.getId());
        }
        return facultyRepository.save(facultyUpdate);
    }

    public Faculty deleteFaculty(long id) {
        Faculty faculty = facultyRepository.findById(id)
                .orElseThrow(() -> new FacultyNotFoundException(id));
        facultyRepository.deleteById(faculty.getId());
        return faculty;
    }

    public List<Faculty> facultyColor(String color) {
        return facultyRepository.findAll().stream().
                filter(faculty -> faculty.getColor() == color).
                collect(Collectors.toList());
    }
}
