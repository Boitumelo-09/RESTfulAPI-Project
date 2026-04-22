package com.belmire.services;

import com.belmire.models.Student;
import com.belmire.repository.StudentRepository;
import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Service
public class StudentService {
    @Autowired
            StudentRepository repository;
//    List<Student> students =  new ArrayList<>(Arrays.asList(new Student(20, "Rahul", "Male", 101),
//            new Student(21, "Raj", "Male", 102),
//            new Student(22, "Ravi", "Male", 103),
//            new Student(23, "Raju", "Male", 104),
//            new Student(24, "Rajesh", "Male", 105),
//            new Student(25, "Rajesh", "Male", 106),
//            new Student(26, "Rajesh", "Male", 107),
//            new Student(27, "MahaRaj", "Male", 108)));



    public Student getStudentByID(int studentID) {

        return repository.findById(studentID).orElse(null);
    }


    public void addStudent(Student student) {
       repository.save(student);
    }

    public void updateStudent(Student student) {
   repository.save(student);
    }
    public void deleteStudentByID(int studentID){
      repository.deleteById(studentID);
    }

    public List<Student> getStudents() {
        return repository.findAll();
    }
}
