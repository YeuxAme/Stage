package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer>{
	
}
