package com.hogwarts.demo.controller;

import com.hogwarts.demo.model.Student;
import com.hogwarts.demo.service.StudentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentServiceImpl studentService;

    public StudentController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    public Student addStudents(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @GetMapping("{id}/get")
    public ResponseEntity<Student> getStudents(@PathVariable Long id) {
        Student newStudent = studentService.findStudent(id);
        if (newStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(newStudent);
    }

    @PutMapping("/update")
    public ResponseEntity<Student> editStudents(@RequestBody Student student) {
        Student changeStudent = studentService.editStudent(student);
        if (changeStudent == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(changeStudent);
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<Student> deleteStudents(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/by-age")
    public List<Student> studentAge(@PathVariable Integer age) {
        return studentService.getAge(age);
    }
}
