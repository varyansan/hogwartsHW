package com.hogwarts.demo.controller;

import com.hogwarts.demo.model.Faculty;
import com.hogwarts.demo.service.FacultyServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

        private FacultyServiceImpl facultyService;

        public FacultyController(FacultyServiceImpl facultyService) {
                this.facultyService = facultyService;
        }

        @PostMapping("/add")
        public Faculty addFaculties(@RequestBody Faculty faculty) {
                return facultyService.addFaculty(faculty);
        }

        @GetMapping("{id}/get")
        public ResponseEntity<Faculty> getFaculties(@PathVariable Long id) {
                Faculty newFaculty = facultyService.findFaculty(id);
                if (newFaculty == null) {
                        return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(newFaculty);
        }

        @PutMapping("/update")
        public ResponseEntity<Faculty> updateFaculties(@RequestBody Faculty faculty) {
                Faculty changeFaculty = facultyService.editFaculty(faculty);
                if (changeFaculty == null) {
                        return ResponseEntity.notFound().build();
                }
                return ResponseEntity.ok(changeFaculty);
        }

        @DeleteMapping("{id}/delete")
        public ResponseEntity<Faculty> deleteFaculties(@PathVariable Long id) {
                facultyService.deleteFaculty(id);
                return ResponseEntity.ok().build();
        }

        @RequestMapping("/get/by-color")
        public List<Faculty> colorsOfFaculty(@RequestParam String color) {
                return facultyService.facultyColor(color);
        }

        @RequestMapping("/get/by-color-or-name")
        public List<Faculty> colorsOrNameOfFaculty(@RequestParam String color,
                                                   @RequestParam String name) {
                return facultyService.colorsOrNameOfFaculty(color, name);
        }

        @GetMapping("/get/by-student/{id}")
        public Faculty findStudents(@PathVariable("id") long id) {
                return facultyService.findStudents(id);
        }
}



