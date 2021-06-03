package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	public Optional<Student> findById(int id) {
		return studentRepository.findById(id);
	}
	
	public List<Student> findAll(){
		return studentRepository.findAll();
		
	}
	
	public Student save(Student student) {
		return studentRepository.save(student);
	}
	
	public void deleteById(int id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> findStudentsByMat(int mat){
		List<Student> students = studentRepository.findAll();
		List<Student> result = new ArrayList<>();
		
		for(int i=0; i<students.size(); i++) {
			Student stud = students.get(i);
			
			if(stud.getMatricola() > mat) {
				result.add(stud);
			}
		}
		
		return result;
		
	}
}
