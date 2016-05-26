package com.quisy.controllers;

import com.quisy.models.Role;
import com.quisy.models.Story;
import com.quisy.models.User;
import com.quisy.models.UserRegisterViewModel;
import com.quisy.services.interfaces.IRoleService;
import com.quisy.services.interfaces.IStoryService;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lampr on 17.05.2016.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {

    private final IUserService<User> _userService;

    @Autowired
    public UserController(IUserService<User> userService) {
        _userService = userService;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody UserRegisterViewModel user) {
        return _userService.register(user);
    }


    @RequestMapping(value="/login")
    public User login()
    {
        return _userService.login("janek@janek.pl","12345");
}



}
