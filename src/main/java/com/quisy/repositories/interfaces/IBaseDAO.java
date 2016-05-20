package com.quisy.repositories.interfaces;

import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lampr on 19.05.2016.
 */
public interface IBaseDAO<T>  {
    void add(T entity);
    void delete(T entity);
    void update(T entity);
    List<T> getAll();
    T getById(long id);
    List<T> getByParameter(String parameter, String value);
    List<T> findBy (Predicate<T> predicate);
}
