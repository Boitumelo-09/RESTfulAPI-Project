package com.belmire.controllers;

import com.belmire.models.Student;
import com.belmire.repository.StudentRepository;
import com.belmire.services.StudentService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class StudentController {

   private final StudentService studentService;
   private  final StudentRepository repository;

    StudentController(StudentService studentService, StudentRepository repository) {
        this.studentService = studentService;
        this.repository = repository;
    }

@GetMapping("/token")
public CsrfToken getToken(HttpServletRequest request) {
       return request.getAttribute("_csrf") != null ? (CsrfToken) request.getAttribute("_csrf") : null;
}
    @GetMapping("/students")
    public ResponseEntity<List<Student>>  getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK) ;
    }

    @GetMapping("/students/{studentID}")
    public ResponseEntity<Student> getStudent(@PathVariable int studentID){
          Student student = studentService.getStudentByID(studentID);
          if(student == null){
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
          return new ResponseEntity<>(student, HttpStatus.OK);
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

