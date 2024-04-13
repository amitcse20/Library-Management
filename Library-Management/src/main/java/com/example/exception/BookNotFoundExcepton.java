package com.example.exception;

public class BookNotFoundExcepton extends RuntimeException{
    public BookNotFoundExcepton(String message){
        super(message);
    }

}
