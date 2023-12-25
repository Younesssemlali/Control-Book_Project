package com.example.book.service;

import com.example.book.dao.entities.Book;
import com.example.book.service.dtos.BookDTO;

import java.util.List;

public interface BookManager {
    public List<BookDTO> getBookByTitle(String titre);
    public List<BookDTO> getBookByPublisherAndPrice(String publisher,double price);
    public BookDTO saveBook(BookDTO bookDto);
    public BookDTO deleteBook(Long id);
}
