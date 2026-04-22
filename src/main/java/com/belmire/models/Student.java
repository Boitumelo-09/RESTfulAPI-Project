package com.belmire.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@Table(name = "students")
public class Student {

    private String name;
    private int age;
    @Id
    private int studentId;
    private String gender;
    public Student() {}
    public Student(int studentId,String name,int age,String gender ) {
        this.age = age;
        this.name = name;
        if(gender.equalsIgnoreCase("Male")){
            this.gender = "M";
        }else{
            this.gender = "F";
        }
        this.studentId = studentId;
    }
}
