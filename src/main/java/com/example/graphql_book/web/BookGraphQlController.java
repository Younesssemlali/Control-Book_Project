package com.example.graphql_book.web;

import com.example.graphql_book.services.dtos.BookDto;
import com.example.graphql_book.services.BookManager;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookGraphQlController {

    private final BookManager bookManager;


    public BookGraphQlController(BookManager bookManager) {
        this.bookManager = bookManager;
    }

    @QueryMapping
    public List<BookDto> getBookByTitle(@Argument String title){
        return bookManager.getBookByTitle(title);
    }
    @QueryMapping
    public List<BookDto> getBookByPublisherAndPrice(@Argument String publisher,@Argument double price){
        return bookManager.getBookByPublisherAndPrice(publisher,price);
    }
    @MutationMapping
    public BookDto saveBook(@Argument BookDto book){
        return bookManager.saveBook(book);
    }
    @MutationMapping
    public BookDto delete(@Argument Long id){
        return bookManager.deleteBook(id);
    }


}
