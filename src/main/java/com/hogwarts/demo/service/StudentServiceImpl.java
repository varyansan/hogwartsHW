package com.hogwarts.demo.service;

import com.hogwarts.demo.exception.FacultyNotFoundException;
import com.hogwarts.demo.exception.StudentNotFoundException;
import com.hogwarts.demo.model.Student;
import com.hogwarts.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findStudent(long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
    }

    @Override
    public Student deleteStudent(long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException(id));
        studentRepository.deleteById(student.getId());
        return student;
    }

    public Student editStudent(Student studentUpdate) {
        if (!studentRepository.existsById(studentUpdate.getId())) {
            throw new FacultyNotFoundException(studentUpdate.getId());
        }
        return studentRepository.save(studentUpdate);
    }


    public List<Student> getAge(Integer age) {
        return studentRepository.findAll().stream().
                filter(student -> student.getAge()==age).
                collect(Collectors.toList());
    }
}
