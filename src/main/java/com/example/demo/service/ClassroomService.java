package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;

@Service
public class ClassroomService {

	@Autowired
	ClassroomRepository classroomRepository;
	
	public Optional<Classroom> findById(int id) {
		return classroomRepository.findById(id);
	}
	
	public List<Classroom> findAll(){
		return classroomRepository.findAll();
	}
	
	public Classroom save(Classroom classroom) {
		return classroomRepository.save(classroom);
	}
	
	public void deleteById(int id) {
		classroomRepository.deleteById(id);
	}
	
	public List<Classroom> findClassroomByClass(int cl){
		List<Classroom> classrooms = classroomRepository.findAll();
		List<Classroom> result = new ArrayList<>();
		
		for(int i=0; i<classrooms.size(); i++) {
			Classroom cr = classrooms.get(i);
			
			if(cr.getClasse() > cl) {
				result.add(cr);
			}
			
		}
		
		return result;
	}
}
