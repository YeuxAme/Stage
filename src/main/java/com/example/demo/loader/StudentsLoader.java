package com.example.demo.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Configuration
public class StudentsLoader {

	@Bean
	public CommandLineRunner initDatabaseStudent(StudentRepository studentRepository) {
		return args -> {
			studentRepository.save(new Student(1, "Lorenzo", "Merlino", "aaabbbccc", 100));
			studentRepository.save(new Student(2, "Gabriele", "Quarini", "dddeeefff", 150));
			studentRepository.save(new Student(3, "Alek", "Pampolina", "habibi", 200));

		};	
	}
}
