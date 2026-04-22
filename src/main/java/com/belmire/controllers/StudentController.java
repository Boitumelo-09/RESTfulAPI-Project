package com.belmire.controllers;

import com.belmire.models.Student;
import com.belmire.repository.StudentRepository;
import com.belmire.services.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository repository;
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
    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
          studentService.addStudent(student);
    }
    @PutMapping("/students")
    public void updateStudent(@RequestBody Student student){
          studentService.updateStudent(student);
    }
    @DeleteMapping("/students/{studentID}")
    public void deleteStudent(@PathVariable int studentID){
          studentService.deleteStudentByID(studentID);
    }
    @GetMapping("/test")
    public String test() {
        return "API working";
    }
    @GetMapping("/count")
    public long count() {
        return repository.count();
    }
    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void printDbUrl() throws Exception {
        System.out.println(dataSource.getConnection().getMetaData().getURL());
    }
}

