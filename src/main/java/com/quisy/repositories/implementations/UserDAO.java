package com.quisy.repositories.implementations;

import com.quisy.models.User;
import com.quisy.repositories.interfaces.IUserDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


/**
 * Created by lampr on 17.05.2016.
 */

@Repository
@Transactional
public class UserDAO extends BaseDAO<User> implements IUserDAO<User> {

    public UserDAO() {
        super(User.class);
    }


}
