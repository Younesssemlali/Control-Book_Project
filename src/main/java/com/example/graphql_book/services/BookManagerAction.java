package com.example.graphql_book.services;


import com.example.graphql_book.services.dtos.BookDto;
import com.example.graphql_book.dao.entities.Book;
import com.example.graphql_book.services.mappers.BookMapper;
import com.example.graphql_book.dao.repositories.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookManagerAction implements BookManager {

    private final IBookRepository iBookRepository;
    private final BookMapper mapper;

    public BookManagerAction(IBookRepository iBookRepository, BookMapper mapper) {
        this.iBookRepository = iBookRepository;
        this.mapper = mapper;
    }


    @Override
    public List<BookDto> getBookByTitle(String titre) {
        return iBookRepository.findBooksByTitreContaining(titre).stream().map(mapper::fromBookToBookDto).collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBookByPublisherAndPrice(String publisher, double price) {
        return iBookRepository.findBooksByPublisherContainingAndPrice(publisher,price).stream().map(mapper::fromBookToBookDto).collect(Collectors.toList());
    }

    @Override
    public BookDto saveBook(BookDto bookDto) {
        Book book = mapper.fromBookDtoToBook(bookDto);
        boolean exist = iBookRepository.existsBookByPublisherAndTitre(book.getPublisher(),book.getTitre());
        if (exist){
            throw new RuntimeException("book exist with this publisher and title");
        }
        Book book1 = iBookRepository.save(book);
        return mapper.fromBookToBookDto(book1);
    }

    @Override
    public BookDto deleteBook(Long id) {
        Book book = iBookRepository.findById(id).orElseThrow(()->new RuntimeException("book doesn't exist"));
        iBookRepository.deleteById(id);
        return mapper.fromBookToBookDto(book);
    }
}
