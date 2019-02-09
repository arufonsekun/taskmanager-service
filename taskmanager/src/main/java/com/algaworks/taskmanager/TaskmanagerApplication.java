package com.algaworks.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/*
 * This class boot the application and initialize the hibernate 
 * configuration xml file*/

@SpringBootApplication
@ImportResource({"classpath:hibernate.cfg.xml"})
public class TaskmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskmanagerApplication.class, args);
	}

}

