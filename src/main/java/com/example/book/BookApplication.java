package com.example.book;

import com.example.book.dao.entities.Book;
import com.example.book.dao.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class BookApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApplication.class, args);
	}
	@Bean
	CommandLineRunner start(BookRepository bookRepository){
		return args -> {
			for (int i = 0; i < 4; i++) {
				Book book = Book.builder()
						.titre("Livre " + i)
						.publisher("Éditeur " + i)
						.date_Publication(new Date())
						.price(15+ i)
						.resume("Résumé du livre " + i)
						.build();

				bookRepository.save(book);
			}

		};
	}
}
