package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Student;

public interface StudentService {

    Integer insert(Student student);

    void update(Student student);

    void deleteById(Integer id);

    Student getById(Integer id);
    
    List<Student> findAll();
}
