package com.quisy.services.implementations;

import com.quisy.models.Role;
import com.quisy.models.User;
import com.quisy.repositories.interfaces.IRoleDAO;
import com.quisy.repositories.interfaces.IUserDAO;
import com.quisy.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lampr on 19.05.2016.
 */


@Service
@Transactional
public class RoleService implements IRoleService<Role> {

    private final IRoleDAO<Role> _roleRepository;

    @Autowired
    public RoleService(IRoleDAO<Role> roleRepository) {
        _roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAll() {
       return _roleRepository.getAll();
    }

    @Override
    public Role getByName(String name) {
        return _roleRepository.getByName(name);
    }
}
