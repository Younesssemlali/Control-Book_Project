package com.example.graphql_book.services;


import com.example.graphql_book.services.dtos.BookDto;

import java.util.List;

public interface BookManager {
    public List<BookDto> getBookByTitle(String titre);
    public List<BookDto> getBookByPublisherAndPrice(String publisher,double price);
    public BookDto saveBook(BookDto bookDto);
    public BookDto deleteBook(Long id);
}
