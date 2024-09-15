package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.service.*;
import java.util.List;
import java.util.Optional;

@RestController

public class MainController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/")
    public String index() {
        return "<!DOCTYPE html>" +
                "<html lang='en'>" +
                "<head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>" +
                "<title>Welcome</title></head>" +
                "<body><h1>Welcome to Spring Boot!</h1></body>" +
                "</html>";  
    }

    @GetMapping("/student")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
    @CrossOrigin(origins = "http://127.0.0.1:5500")
    @GetMapping("/student{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Optional<Student> student = studentService.getStudentById(id);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
   
    @DeleteMapping("/student{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") int id) {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    
    
    @GetMapping("/student/gender/{gender}")
    public ResponseEntity<List<Student>> getStudenByG(@PathVariable("gender")String gender) {
    	Optional<List<Student>> student = studentService.getStudentByGender(gender);
        if (student.isPresent()) {
            return ResponseEntity.ok(student.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
