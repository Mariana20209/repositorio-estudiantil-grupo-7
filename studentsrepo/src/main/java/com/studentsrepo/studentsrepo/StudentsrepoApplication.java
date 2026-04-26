package com.studentsrepo.studentsrepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class StudentsrepoApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentsrepoApplication.class, args);
	}

}
