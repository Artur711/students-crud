package com.example.studentsCrud.Model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotBlank;

@Entity
public class Student {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotBlank(message = "First name can't be blank")
    private String first_name;

//    @NotBlank(message = "Last name can't be blank")
    private String last_name;

//    @NotBlank(message = "Age can't be blank")
    private  long age;

    public Student(){}

    public Student(String first_name, String last_name, long age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }

    public Student(long id, String first_name, String last_name, long age){
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.age = age;
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
