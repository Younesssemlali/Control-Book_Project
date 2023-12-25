package com.example.book.service.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor @NoArgsConstructor @Builder

public class BookDTO {
    private String titre;
    private String publisher;
    private Date datePublication;
    private double price;

}
