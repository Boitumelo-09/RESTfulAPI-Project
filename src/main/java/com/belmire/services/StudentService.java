package com.belmire.services;

import com.belmire.models.Student;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Getter
@Service
public class StudentService {
    List<Student> students = Arrays.asList(new Student(20, "Rahul", "Male", 101),
            new Student(21, "Raj", "Male", 102),
            new Student(22, "Ravi", "Male", 103),
            new Student(23, "Raju", "Male", 104),
            new Student(24, "Rajesh", "Male", 105),
            new Student(25, "Rajesh", "Male", 106),
            new Student(26, "Rajesh", "Male", 107),
            new Student(27, "MahaRaj", "Male", 108));

}
