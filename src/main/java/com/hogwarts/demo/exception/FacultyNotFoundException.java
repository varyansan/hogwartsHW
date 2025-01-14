package com.hogwarts.demo.exception;

public class FacultyNotFoundException extends RuntimeException{

    public FacultyNotFoundException(long id) {
        super("Faculty not found by ID: [%s]".formatted(id));
    }
}
