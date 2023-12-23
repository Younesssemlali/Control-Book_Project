package com.example.graphql_book.dao.repositories;



import com.example.graphql_book.dao.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBookRepository extends JpaRepository<Book,Long> {
    List<Book> findBooksByTitreContaining(String titre);
    List<Book> findBooksByPublisherContainingAndPrice(String publisher,double price);
    boolean  existsBookByPublisherAndTitre(String publisher,String titre);
}
