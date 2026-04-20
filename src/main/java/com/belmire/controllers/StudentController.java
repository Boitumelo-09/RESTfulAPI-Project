package com.belmire.controllers;

import com.belmire.models.Student;
import com.belmire.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
      StudentController(StudentService studentService) {
        this.studentService = studentService;
      }
    @RequestMapping("/students")
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @RequestMapping("/students/{studentID}")
    public Student getStudent(@PathVariable int studentID){
          return studentService.getStudentByID(studentID);
    }
}
