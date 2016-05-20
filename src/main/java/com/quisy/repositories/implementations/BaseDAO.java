package com.quisy.repositories.implementations;

import com.quisy.models.User;
import com.quisy.repositories.interfaces.IBaseDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by lampr on 17.05.2016.
 */

public abstract class BaseDAO<T> implements IBaseDAO<T> {

    private final Class<T> _typeParameterClass;

    @PersistenceContext
    public EntityManager entityManager;

    protected BaseDAO(Class<T> typeParameterClass) {
        _typeParameterClass = typeParameterClass;
    }

    @Override
    public void add(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void delete(T entity) {
        if (entityManager.contains(entity))
            entityManager.remove(entity);
        else
            entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("from " + _typeParameterClass.getSimpleName()).getResultList();
    }

    @Override
    public T getById(long id) {
        return entityManager.find(_typeParameterClass, id);
    }

    @Override
    public List<T> getByParameter(String parameter, String value) {
        String queryString = "from " + _typeParameterClass.getSimpleName() + " where " + parameter + " = :val";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("val", value);
        return query.getResultList();
    }

    @Override
    public List<T> findBy(Predicate<T> predicate) {
        return getAll().stream().filter(predicate).collect(Collectors.toList());
    }
}
