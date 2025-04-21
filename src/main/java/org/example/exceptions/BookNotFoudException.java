package org.example.exceptions;

public class BookNotFoudException extends RuntimeException {

    public BookNotFoudException(Integer id) {
        super("Book Not Foud: " + id);
    }
}
