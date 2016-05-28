package com.quisy.services.interfaces;

import com.quisy.models.UserRegisterViewModel;

/**
 * Created by lampr on 17.05.2016.
 */
public interface IUserService<T> {
    T login(String email, String password);
    T register(UserRegisterViewModel user);
    void update(T entity);
    void delete(T entity);
    T getInfo(long id);
}
