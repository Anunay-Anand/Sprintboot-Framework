package com.sprintBoot;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SprintBootApplication implements CommandLineRunner {

	@Autowired
	DB db;

	public static void main(String[] args) {
		// Configuration of dotenv
		Dotenv dotenv = Dotenv.configure().directory("C:/projects/JavaProjects/sprint-boot/sprint-boot").load();
		dotenv.entries().forEach((entry) -> System.setProperty(
				entry.getKey(), entry.getValue()
		));

		SpringApplication.run(SprintBootApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println(db.getData());
	}
}
