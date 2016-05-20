package com.quisy.services.implementations;

import com.quisy.models.Story;
import com.quisy.repositories.interfaces.IStoryDAO;
import com.quisy.services.interfaces.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by lampr on 18.05.2016.
 */

@Service
@Transactional
public class StoryService implements IStoryService<Story>{

    private final IStoryDAO<Story> _storyRepository;

    @Autowired
    public StoryService(IStoryDAO<Story> storyRepository)
    {
        _storyRepository = storyRepository;
    }

    @Override
    public void create(Story story) {
        _storyRepository.add(story);
    }

    @Override
    public void delete(Story story) {

    }

    @Override
    public void update(Story story) {
        _storyRepository.update(story);
    }

    @Override
    public List<Story> getAll() {
        return _storyRepository.getAll();
    }

    @Override
    public Story getById(long id) {
        return _storyRepository.getById(id);
    }
}
