package com.quisy.services.interfaces;

/**
 * Created by lampr on 17.05.2016.
 */
public interface IUserService<T> {
    T login(String email, String password);
    String register(T entity);
    void update(T entity);
    void delete(T entity);
}
