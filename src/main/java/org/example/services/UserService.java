package org.example.services;

import org.example.exceptions.BookNotFoudException;
import org.example.exceptions.DatabaseException;
import org.example.models.entities.User;
import org.example.repositories.UserRepository;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IService<User> {

    private static UserService instance;
    private final UserRepository userRepository;

    private UserService() {
        this.userRepository = UserRepository.getInstance();
    }


    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }


    @Override
    public void save(User user) {
        try {
            userRepository.save(user);
        } catch (SQLException e) {
            throw new DatabaseException("Error al guardar usuario. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users;
        try {
            users = userRepository.findAll();
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar usuarios. No se pudo acceder a la base de datos. ", e);
        }
        return users;
    }

    @Override
    public User findById(Integer id) {
        try {
            return userRepository.findById(id).orElseThrow(() -> new BookNotFoudException(id));
        } catch (SQLException e) {
            throw new DatabaseException("Error al buscar usuario por id. No se pudo acceder a la base de datos. ", e);
        }
    }

    @Override
    public void delete(User user) {

        try {
            userRepository.delete(user);
        } catch (SQLException e) {
            throw new DatabaseException("Error al eliminar usuario. No se pudo acceder a la base de datos. ", e);
        }
    }
}
