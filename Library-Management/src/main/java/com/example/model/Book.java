package com.example.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "BOOK")
public class Book {
    @Id
    private String id;
    private String bookName;
    private String autherName;
    private String publishedOn;
    public BigDecimal price;

}
