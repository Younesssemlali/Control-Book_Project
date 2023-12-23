package com.example.graphql_book.services.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BookDto {
    private String titre;
    private String publisher;
    private Date date_Publication;
    private double price;
    private String resume;
}
