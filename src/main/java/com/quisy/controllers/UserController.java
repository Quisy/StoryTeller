package com.quisy.controllers;

import com.quisy.models.User;
import com.quisy.models.UserRegisterViewModel;
import com.quisy.models.UserUpdateViewModel;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */
@RestController
@RequestMapping(value = "/api/users")
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


    @RequestMapping(value = "/login/{email}/{password}")
    public ResponseEntity<?> login(@PathVariable(value = "email") String email, @PathVariable(value = "password") String password) {
        User user = _userService.login(email, password);
        if (user == null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "/info/{id}")
    public User getInfo(@PathVariable(value = "id") long id) {
        return _userService.getInfo(id);
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public List<User> getAll() {
        return _userService.getAll();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity getAll(@RequestBody UserUpdateViewModel user) {
        _userService.update(user);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity delete(@PathVariable(value = "id") long id) {
        _userService.delete(id);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(value = "/uploadAvatar/{userId}", method = RequestMethod.POST, headers = "content-type=multipart/form-data")
    public ResponseEntity<?> uploadAvatar(@RequestBody MultipartFile file, @PathVariable(value = "userId") long userId) {
        _userService.updateAvatar(file, userId);
        return ResponseEntity.ok(null);

    }

}
