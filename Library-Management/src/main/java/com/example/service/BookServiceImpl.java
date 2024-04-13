package com.example.service;

import com.example.exception.BookNotFoundExcepton;
import com.example.model.Book;
import com.example.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;

    @Override
    public String addBook(Book book) {
        bookRepo.save(book);
        return "Book added SuccessFully";
    }

    @Override
    public Book findBookById(String id) {
        return bookRepo.findById(id).orElseThrow(()->new BookNotFoundExcepton("Please Enter valid ID"));
    }

    @Override
    public String deleteBooK(String id) {
        bookRepo.deleteById(id);
        return "Book deleted Successfully";
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book updateProduct(Book book) {
        Optional<Book> bookDb = this.bookRepo.findById(book.getId());

        if (bookDb.isEmpty()){
            throw new BookNotFoundExcepton("Book not found with the given ID");
        }
        Book bookUpdate = bookDb.get();
        bookUpdate.setBookName(book.getBookName());
        bookUpdate.setAutherName(book.getAutherName());
        bookUpdate.setPublishedOn(book.getPublishedOn());
        bookUpdate.setPrice(book.getPrice());
        bookRepo.save(bookUpdate);
        return bookUpdate;    }
}
