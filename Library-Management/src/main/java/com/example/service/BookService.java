package com.example.service;

import com.example.model.Book;

import java.util.List;

public interface BookService {
    public String addBook(Book book);
    public Book findBookById(String id);
    public String deleteBooK(String id);
    public List<Book> findAllBooks();
    public Book updateProduct(Book book);

}
