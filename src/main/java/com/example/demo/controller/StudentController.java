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
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students/{id}")
	public Optional<Student> getStudent(@PathVariable int id) {
		return studentService.findById(id);
		//return new Student(1, "Lorenzo", "Merlino", "aaabbbccc", "123456");
	}
	
	@GetMapping("/students/all")
	public List<Student> getAllStudents() {
		return studentService.findAll();
	}
	
	@PostMapping("/students/save")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.save(student);
	}
	
	@PutMapping ("/students/{id}/update")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		Optional<Student> stud = studentService.findById(id);
		if(stud.isEmpty()) {
			throw new RuntimeException("Invalid id");
		}
		return studentService.save(student);
	}
	
	@DeleteMapping ("/students/{id}/delete")
	public void deleteStudent(@PathVariable int id) {
		studentService.deleteById(id);
	}
	
	@GetMapping("/students/mat/{mat}")
	public List<Student> getStudentByMat(@PathVariable int mat){	
		return studentService.findStudentsByMat(mat);
	}
	
	
}
