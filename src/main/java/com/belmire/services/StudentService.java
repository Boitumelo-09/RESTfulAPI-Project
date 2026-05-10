package com.belmire.services;

import com.belmire.models.Student;
import com.belmire.repository.StudentRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Data
@Service
public class StudentService {

    private final StudentRepository repository;

    StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    public Student getStudentByID(int studentID) {

        return repository.findById(studentID).orElse(null);
    }


    public void addStudent(Student student) {
        repository.save(student);
    }

    public void updateStudent(Student student) {
        repository.save(student);
    }

    public void deleteStudentByID(int byId) {repository.deleteById(byId);}

    public List<Student> getStudents() {
        return repository.findAll();
    }
}
