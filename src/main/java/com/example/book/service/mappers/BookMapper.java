package com.example.book.service.mappers;

import com.example.book.dao.entities.Book;
import com.example.book.service.dtos.BookDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    private ModelMapper modelMapper = new ModelMapper();
    public Book fromBookDTOtoBook(BookDTO bookDTO){
        return this.modelMapper.map(bookDTO,Book.class);

    }
    public BookDTO fromCarToCarDTO(Book book){
        return this.modelMapper.map(book, BookDTO.class);
    }


}
