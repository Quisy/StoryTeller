package com.quisy.services.interfaces;

import com.quisy.models.Story;
import com.quisy.models.StoryAddViewModel;
import com.quisy.models.StoryViewModel;

import java.util.List;

/**
 * Created by lampr on 18.05.2016.
 */
public interface IStoryService<T> {

    void create(StoryAddViewModel entity);
    void delete(T entity);
    void update(T entity);
    List<StoryViewModel> getAll();
    Story getById(long id);
    List<T> getForUser(long userId);
}
