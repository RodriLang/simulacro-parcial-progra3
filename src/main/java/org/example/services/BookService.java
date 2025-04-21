package org.example.services;

import org.example.exceptions.BookNotFoudException;
import org.example.exceptions.DatabaseException;
import org.example.models.entities.Book;
import org.example.repositories.BookRepository;

import java.sql.SQLException;
import java.util.List;

public class BookService implements IService<Book>{

    private static BookService instance;
    private final BookRepository bookRepository;

    private BookService() {
        this.bookRepository = BookRepository.getInstance();
    }


    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
        }
        return instance;
    }


    @Override
    public void save(Book book) {
        try {
            bookRepository.save(book);
        } catch (SQLException e) {
            throw new DatabaseException("Error al guardar libro. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public List<Book> findAll() {
        List<Book> books;
        try {
            books = bookRepository.findAll();
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar libros. No se pudo acceder a la base de datos. ", e);
        }
        return books;
    }

    @Override
    public Book findById(Integer id) {
        try {
            return bookRepository.findById(id).orElseThrow(()-> new BookNotFoudException(id));
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar libro por id. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public void delete(Book book) {

        try {
            bookRepository.delete(book);
        } catch (SQLException e) {
            throw new DatabaseException("Error al eliminar libro. No se pudo acceder a la base de datos. ", e);
        }
    }
}
