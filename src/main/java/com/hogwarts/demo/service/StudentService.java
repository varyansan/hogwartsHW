package com.hogwarts.demo.service;

import com.hogwarts.demo.model.Student;

public interface StudentService {

    Student addStudent(Student student);

    Student findStudent(long id);

    Student editStudent(Student studentUpdate);

    Student deleteStudent(long id);
}
