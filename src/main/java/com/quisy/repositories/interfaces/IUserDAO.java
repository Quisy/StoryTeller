package com.quisy.repositories.interfaces;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by lampr on 17.05.2016.
 */


public interface IUserDAO<T> extends IBaseDAO<T>{

}
