package com.quisy.controllers;

import com.quisy.models.User;
import com.quisy.models.UserRegisterViewModel;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lampr on 17.05.2016.
 */
@RestController
@RequestMapping(value="/api/users")
public class UserController {

    private final IUserService<User> _userService;

    @Autowired
    public UserController(IUserService<User> userService) {
        _userService = userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody UserRegisterViewModel user) {
        return _userService.register(user);
    }


    @RequestMapping(value="/login/{email}/{password}")
    public User login(@PathVariable(value="email") String email, @PathVariable(value="password") String password)
    {
        return _userService.login(email,password);
    }



}
