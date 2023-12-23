package com.example.graphql_book.services.mappers;


import com.example.graphql_book.services.dtos.BookDto;
import com.example.graphql_book.dao.entities.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private final ModelMapper modelMapper;

    public BookMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public BookDto fromBookToBookDto(Book book){
        return modelMapper.map(book, BookDto.class);
    }
    public Book fromBookDtoToBook(BookDto bookDto){
        return modelMapper.map(bookDto, Book.class);
    }

}
