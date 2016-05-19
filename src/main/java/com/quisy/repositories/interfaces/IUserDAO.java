package com.quisy.repositories.interfaces;

import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */
public interface IUserDAO<T> {
    void add(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> getAll();
    T getById(long id);
    List<T> getByParameter(String parameter, String value);
}
