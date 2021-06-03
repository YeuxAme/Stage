package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Classroom;
import com.example.demo.model.Student;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.service.ClassroomService;

@RestController
public class ClassroomController {

	@Autowired
	private ClassroomService classroomService;
	
	@GetMapping ("/Classrooms/{id}")
	public Optional<Classroom> getClassroom(int id) {
		return classroomService.findById(id);
		//return new Classroom(1, 4, "Info-B");
	}
	
	@GetMapping ("/Classrooms/all")
	public List<Classroom> getAllClassrooms(){
		return classroomService.findAll();
		
	}
	
	@PostMapping ("/Classrooms/save")
	public Classroom insertClassroom(@RequestBody Classroom classroom) {
		return classroomService.save(classroom);
	}
	
	@PutMapping ("/Classrooms/{id}/update")
	public Classroom updateClassroom(@PathVariable int id, @RequestBody Classroom classroom) {
		Optional<Classroom> cr = classroomService.findById(id);
		if(cr.isEmpty()) {
			throw new RuntimeException("Invalid id");
		}
		return classroomService.save(classroom);
	}
	
	@DeleteMapping ("/Classrooms/{id}/delete")
	public void deleteClassroom(@PathVariable int id) {
		classroomService.deleteById(id);
	}
	
	@GetMapping ("Classrooms/class/{cl}")
	public List<Classroom> getClassroomByClass(@PathVariable int cl){
		return classroomService.findClassroomByClass(cl);
	}
	
}
