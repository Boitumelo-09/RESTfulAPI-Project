package com.belmire.controllers;

import com.belmire.models.Student;
import com.belmire.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
      StudentController(StudentService studentService) {
        this.studentService = studentService;
      }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
          return studentService.getStudentByID(studentID);
    }
    @PostMapping("/student")
    public void addStudent(@RequestBody Student student){
          studentService.addStudent(student);
    }
}
