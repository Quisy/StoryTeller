package com.quisy.repositories.implementations;

import com.quisy.models.User;
import com.quisy.repositories.BaseDAO;
import com.quisy.repositories.interfaces.IUserDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lampr on 17.05.2016.
 */

@Repository
@Transactional
public class UserDAO extends BaseDAO implements IUserDAO<User> {


    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        if (entityManager.contains(user))
            entityManager.remove(user);
        else
            entityManager.remove(entityManager.merge(user));
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("from User").getResultList();
    }


    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getByParameter(String parameter, String value) {
        String queryString = "from User where " + parameter + " = :val";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("val", value);
        return query.getResultList();
    }

}
