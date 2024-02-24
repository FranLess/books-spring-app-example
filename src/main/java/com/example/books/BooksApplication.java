package com.example.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.books.Repository.UserRepository;
import com.example.books.Entity.User;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BooksApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);
		User user = new User("Francisco", "fran@example.com", "password");
		repository.save(user);
	}

}
