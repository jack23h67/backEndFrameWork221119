package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Component
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentAccountMapper;

    @Override
    public Integer insert(Student student) {
        return studentAccountMapper.insert(student);
    }

    @Override
    public void update(Student student) {
    	studentAccountMapper.update(student);
    }

    @Override
    public void deleteById(Integer id) {
    	studentAccountMapper.deleteById(id);
    }

    @Override
    public Student getById(Integer id) {
        return studentAccountMapper.getById(id);
    }

	@Override
	public List<Student> findAll() {
		return studentAccountMapper.getList();
	}
    
    
}
