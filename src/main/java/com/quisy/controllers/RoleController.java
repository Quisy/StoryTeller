package com.quisy.controllers;

import com.quisy.models.Role;
import com.quisy.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Mariusz on 2016-05-29.
 */

@RestController
@RequestMapping(value="/api/role")
public class RoleController {


    private final IRoleService<Role> _roleService;

    @Autowired
    public RoleController(IRoleService<Role> roleService)
    {
        _roleService = roleService;
    }


    @RequestMapping(value="/get", method= RequestMethod.GET)
    @ResponseBody
    public List<Role> getAll() {
        return _roleService.getAll();
    }
}
