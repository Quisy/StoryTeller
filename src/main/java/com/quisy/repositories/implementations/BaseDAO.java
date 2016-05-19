package com.quisy.repositories.implementations;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by lampr on 17.05.2016.
 */

public abstract class BaseDAO {

    @PersistenceContext
    public EntityManager entityManager;

}
