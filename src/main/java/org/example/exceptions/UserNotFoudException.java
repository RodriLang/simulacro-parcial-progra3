package org.example.exceptions;

public class UserNotFoudException extends RuntimeException {

    public UserNotFoudException(Integer id) {
        super("Book Not Foud: " + id);
    }
}
