package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {

    public final static List<Student> STUDENTS = Arrays.asList(
        new Student(1, "Alice"),
        new Student(2, "Eve"),
        new Student(3, "annasmith")
    );

    @GetMapping
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    public Student getStudentById(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
            .filter(student -> student.studentId().equals(studentId))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exist"));
    }

}
