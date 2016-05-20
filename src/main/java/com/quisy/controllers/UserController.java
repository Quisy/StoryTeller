package com.quisy.controllers;

import com.quisy.models.Role;
import com.quisy.models.Story;
import com.quisy.models.User;
import com.quisy.services.interfaces.IRoleService;
import com.quisy.services.interfaces.IStoryService;
import com.quisy.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lampr on 17.05.2016.
 */
@RestController
@RequestMapping(value="/users")
public class UserController {

    private final IUserService<User> _userService;

    @Autowired
    private  IStoryService<Story> _storyService;

    @Autowired
    private IRoleService<Role> _roleService;

    @Autowired
    public UserController(IUserService<User> userService) {
        _userService = userService;
    }

    @RequestMapping(value="/register")
    public String register()
    {
        User user = new User();
        user.setName("Jan");
        user.setSurname("Kowalski");
        user.setNickName("janek");
        user.setEmail("janek@janek.pl");
        user.setPassword("12345");
        user.setRole(_roleService.getAll().get(0));

        Story story = new Story();
        story.setTitle("Test");
        story.setText("BLA BLA BLA");
        story.setOwner(user);


        String message =  _userService.register(user);
        _storyService.create(story);

        return message;
    }

    @RequestMapping(value="/login")
    public User login()
    {
        return _userService.login("janek@janek.pl","12345");
}

    @RequestMapping(value="/test")
    public String test()
    {
        return _roleService.getAll().get(1).getName();
    }

}
