package com.example.graphql_book;


import com.example.graphql_book.dao.entities.Book;
import com.example.graphql_book.dao.repositories.IBookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GraphQlBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraphQlBookApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }


    @Bean
    public CommandLineRunner start(IBookRepository bookRepository){
        return args ->{
            Book book = Book.builder().titre("spring").price(12.99).date_Publication(new Date()).publisher("youness").resume("Spring Boot resume").build();
            Book book1 = Book.builder().titre("security").price(21.99).date_Publication(new Date()).publisher("semlali").resume("Spring security resume").build();
            Book book2 = Book.builder().titre("graphQl").price(98.99).date_Publication(new Date()).publisher("ahmed").resume("Spring graphql resume").build();
            Book book3 = Book.builder().titre("data").price(45.99).date_Publication(new Date()).publisher("ashraf").resume("Spring data resume").build();

            bookRepository.saveAll(List.of(book,book1,book2,book3));
        };
    }
}
