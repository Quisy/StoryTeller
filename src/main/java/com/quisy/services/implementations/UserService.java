package com.quisy.services.implementations;

import com.quisy.models.User;
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

    @Autowired
    public UserService(IUserDAO<User> userRepository){
        _userRepository = userRepository;
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
    public String register(User user) {
        try {
            if (_userRepository.getByParameter("email", user.getEmail()).size() == 0) {
                _userRepository.add(user);
                return "User added";
            } else {
                return "Email already in use!";
            }
        }
        catch (Exception ex) {
            return "Error: " + ex.toString();
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
}
