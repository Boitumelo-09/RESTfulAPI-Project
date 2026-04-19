package com.belmire.models;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class Student {

    private String name;
    private int age;
    private int studentId;
    private String gender;
    public Student() {}
    public Student(int age, String name, String gender, int studentId) {
        this.age = age;
        this.name = name;
        this.gender = gender;
        this.studentId = studentId;
    }
}
