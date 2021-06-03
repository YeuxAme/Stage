package com.example.demo.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Classroom;
import com.example.demo.repository.ClassroomRepository;

@Configuration
public class ClassroomsLoader {
	
	@Bean
	public CommandLineRunner initDatabaseClassroom(ClassroomRepository classroomRepository) {
		return args -> {
			
			classroomRepository.save(new Classroom(1, 4, "Info-B"));
			classroomRepository.save(new Classroom(2, 4, "Info-A"));
			classroomRepository.save(new Classroom(3, 5, "Info-B"));
			classroomRepository.save(new Classroom(4, 5, "Info-A"));
		
		};
		
	}

}
