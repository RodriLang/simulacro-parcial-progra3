package org.example.services;

import java.util.List;

public interface IService<T>{

    void save(T t);

    List<T> findAll();

    T findById(Integer id);

    void delete(T t);
}
