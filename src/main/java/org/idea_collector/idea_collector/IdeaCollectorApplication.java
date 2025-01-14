package org.idea_collector.idea_collector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Idea Collector API", version = "1.0", description = "A API for storing and managing the Ideas" ,
					contact = @Contact(name = "Harshith N J", email = "Harshith.dev2024@outlook.com")))
public class IdeaCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeaCollectorApplication.class, args);
	}

}
