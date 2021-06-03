package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return studentRepository.findById(id);
		//return new Student(1, "Lorenzo", "Merlino", "aaabbbccc", "123456");
	}
	
	@GetMapping("/students/all")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@PostMapping("/students/save")
	public Student insertStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping ("/students/{id}/update")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Optional<Student> stud = studentRepository.findById(id);
		if(stud.isEmpty()) {
			throw new RuntimeException("Invalid id");
		}
		return studentRepository.save(student);
	}
	
	@DeleteMapping ("/students/{id}/delete")
	public void deleteStudent(@PathVariable int id) {
		studentRepository.deleteById(id);
	}
	
	
}
