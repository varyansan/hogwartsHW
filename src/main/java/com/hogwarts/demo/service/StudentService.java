package com.hogwarts.demo.service;

import com.hogwarts.demo.model.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    Student findStudent(long id);

    Student editStudent(Student studentUpdate);

    Student deleteStudent(long id);

    List<Student> getAge(Integer age);

    List<Student> findByAgeBetween (int min, int max);
}
