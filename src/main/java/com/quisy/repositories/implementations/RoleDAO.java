package com.quisy.repositories.implementations;

import com.quisy.models.Role;
import com.quisy.repositories.interfaces.IRoleDAO;
import com.quisy.repositories.interfaces.IStoryDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by lampr on 19.05.2016.
 */


@Repository
@Transactional
public class RoleDAO extends BaseDAO<Role> implements IRoleDAO<Role> {

    protected RoleDAO() {
        super(Role.class);
    }

    @Override
    public Role getByName(String name) {
        return getByParameter("Name", name).get(0);
    }
}
