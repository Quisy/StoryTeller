package com.quisy.services.implementations;

import com.quisy.models.Role;
import com.quisy.models.User;
import com.quisy.models.UserRegisterViewModel;
import com.quisy.repositories.interfaces.IRoleDAO;
import com.quisy.repositories.interfaces.IUserDAO;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by lampr on 17.05.2016.
 */

@Service
@Transactional
public class UserService implements IUserService<User> {

    private final IUserDAO<User> _userRepository;
    private final IRoleDAO<Role> _roleRepository;

    @Autowired
    public UserService(IUserDAO<User> userRepository, IRoleDAO<Role> roleRepository){
        _userRepository = userRepository;
        _roleRepository = roleRepository;
    }


    @Override
    public User login(String email, String password) {
        try{
            return _userRepository.getAll().stream().filter(
                    u -> u.getEmail().equals(email) && u.getPassword().equals(password)).findFirst().get();
        }
        catch (Exception ex) {
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
            if (_userRepository.getByParameter("email", user.getEmail()).size() == 0) {
                _userRepository.add(user);
                return user;
            } else {
                return null;
            }
        }
        catch (Exception ex) {
            return null;
        }

    }

    @Override
    public void update(User user) {
        _userRepository.update(user);
    }

    @Override
    public void delete(User user) {
        _userRepository.delete(user);
    }

    @Override
    public User getInfo(long id) {
       return _userRepository.getById(id);
    }
}
