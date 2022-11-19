package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    @Operation(summary = "新增某一筆學生資料", description = "")
    public ResponseEntity<Student> create(@RequestBody Student student) {

        Integer studentId = studentService.insert(student);

        Student newStudent = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
    }

    @PutMapping("/students/{studentId}")
    @Operation(summary = "用id去更新某一筆學生資料", description = "")
    public ResponseEntity<?> update(@PathVariable Integer studentId,
                                    @RequestBody Student student) {

        student.setId(studentId);
        studentService.update(student);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/students/{studentId}")
    @Operation(summary = "用id去刪除某一筆學生資料", description = "")
    public ResponseEntity<?> delete(@PathVariable Integer studentId) {

        studentService.deleteById(studentId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/students/{studentId}")
    @Operation(summary = "用id去取得某一筆學生資料", description = "")
    public ResponseEntity<Student> findById(@PathVariable Integer studentId) {

        Student student = studentService.getById(studentId);

        return ResponseEntity.status(HttpStatus.OK).body(student);
    }
    
    @GetMapping("/students")
    @Operation(summary = "取得學生列表", description = "")
    public List<Student> findAll() {

        List<Student> studentList = studentService.findAll();

        return studentList;
    }
}