package com.quisy.services.interfaces;

import com.quisy.models.UserRegisterViewModel;
import com.quisy.models.UserUpdateViewModel;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */
public interface IUserService<T> {
    T login(String email, String password);
    T register(UserRegisterViewModel user);
    void update(UserUpdateViewModel entity);
    void updateAvatar(MultipartFile file, long userId);
    void delete(long id);
    T getInfo(long id);
    List<T> getAll();
}
