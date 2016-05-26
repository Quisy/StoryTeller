package com.quisy.services.interfaces;

import com.quisy.models.Role;

import java.util.List;

/**
 * Created by lampr on 19.05.2016.
 */

public interface IRoleService<T> {
    List<Role> getAll();

    Role getByName(String name);
}
