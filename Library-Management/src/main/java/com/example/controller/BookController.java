package com.example.controller;

import com.example.model.Book;
import com.example.service.BookServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookServiceImpl bookService;

    public BookController(BookServiceImpl bookService) {
        this.bookService = bookService;
    }


    @PostMapping("/add")
    @Operation(summary = "This endpoint will allow you to add new books into DB")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.addBook(book));
    }

    @GetMapping("/{id}")
    @Operation(summary = "This endpoint will allow you to find book from DB")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String id){
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping("/find-all-books")//make it as per rest api standard
    @Operation(summary = "This endpoint will allow you to find all books from DB")
    public ResponseEntity<List<Book>> findAllBooks(){
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "This endpoint will allow you to delete the selected book from DB")
    public ResponseEntity<String> deleteBook(@PathVariable("id") String id){
        return ResponseEntity.ok(bookService.deleteBooK(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "This endpoint will allow you to update books from DB")
    public ResponseEntity<Book> updateBook(@PathVariable String id, @RequestBody Book book){
        book.setId(id);
        return ResponseEntity.ok(bookService.updateProduct(book));
    }

}
