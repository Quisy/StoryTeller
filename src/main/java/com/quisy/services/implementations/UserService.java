package com.quisy.services.implementations;

import com.quisy.models.*;
import com.quisy.repositories.interfaces.IRoleDAO;
import com.quisy.repositories.interfaces.IStoryDAO;
import com.quisy.repositories.interfaces.IUserDAO;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */

@Service
@Transactional
public class UserService implements IUserService<User> {

    private final IUserDAO<User> _userRepository;
    private final IRoleDAO<Role> _roleRepository;
    private final IStoryDAO<Story> _storyRepository;

    @Autowired
    public UserService(IUserDAO<User> userRepository, IRoleDAO<Role> roleRepository, IStoryDAO<Story> storyRepository) {
        _userRepository = userRepository;
        _roleRepository = roleRepository;
        _storyRepository = storyRepository;
    }


    @Override
    public User login(String email, String password) {
        try {
            return _userRepository.getAll().stream().filter(
                    u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().get();
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User register(UserRegisterViewModel registeredUser) {

        User user = new User();
        user.setName(registeredUser.getName());
        user.setSurname(registeredUser.getSurname());
        user.setEmail(registeredUser.getEmail());
        user.setNickName(registeredUser.getNickName());
        user.setPassword(registeredUser.getPassword());
        user.setRole(_roleRepository.getByName("user"));
        registeredUser.setRole("user");

        try {
            if (_userRepository.getByParameter("email", user.getEmail()).size() == 0 && _userRepository.getByParameter("nickName", user.getNickName()).size() == 0) {
                _userRepository.add(user);
                return user;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public void update(UserUpdateViewModel user) {
        User updatedUser = _userRepository.getById(user.getId());
        updatedUser.setName(user.getName());
        updatedUser.setSurname(user.getSurname());
        updatedUser.setEmail(user.getEmail());
        updatedUser.setNickName(user.getNickName());
        updatedUser.setRole(_roleRepository.getByName(user.getRole().getName()));
        _userRepository.update(updatedUser);
    }

    @Override
    public void updateAvatar(MultipartFile file, long userId) {
        try {
            User user = _userRepository.getById(userId);
            byte[] fileBytes = file.getBytes();
            user.setAvatar(fileBytes);
            _userRepository.update(user);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        User user = _userRepository.getById(id);
        if (user != null)
        {
            user.getStories().forEach(_storyRepository::delete);
            _userRepository.delete(user);
        }
    }

    @Override
    public User getInfo(long id) {
        return _userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
        return _userRepository.getAll();
    }
}
