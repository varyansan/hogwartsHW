package com.hogwarts.demo.exception;

public class StudentNotFoundException extends RuntimeException{

    public StudentNotFoundException(long id) {
        super("Student not found by ID: [%s]".formatted(id));
    }
}
