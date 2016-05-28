package com.quisy.services.interfaces;

import com.quisy.models.Story;
import com.quisy.models.StoryAddViewModel;

import java.util.List;

/**
 * Created by lampr on 18.05.2016.
 */
public interface IStoryService<T> {

    void create(StoryAddViewModel entity);
    void delete(T entity);
    void update(T entity);
    List<Story> getAll();
    Story getById(long id);
    List<Story> getForUser(long userId);
}
