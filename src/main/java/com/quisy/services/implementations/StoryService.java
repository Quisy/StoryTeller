package com.quisy.services.implementations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.quisy.models.Story;
import com.quisy.models.StoryAddViewModel;
import com.quisy.models.StoryViewModel;
import com.quisy.models.User;
import com.quisy.repositories.interfaces.IStoryDAO;
import com.quisy.repositories.interfaces.IUserDAO;
import com.quisy.services.interfaces.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lampr on 18.05.2016.
 */

@Service
@Transactional
public class StoryService implements IStoryService<Story>{

    private final IStoryDAO<Story> _storyRepository;
    private final IUserDAO<User> _userRepository;

    @Autowired
    public StoryService(IStoryDAO<Story> storyRepository,IUserDAO<User> userRepository)
    {
        _storyRepository = storyRepository;
        _userRepository = userRepository;
    }

    @Override
    public void create(StoryAddViewModel story) {
        Story newStory = new Story();
        newStory.setTitle(story.getTitle());
        newStory.setText(story.getText());
        newStory.setOwner(_userRepository.getById(story.getUserId()));
        _storyRepository.add(newStory);
    }

    @Override
    public void delete(Story story) {

    }

    @Override
    public void update(Story story) {
        _storyRepository.update(story);
    }

    @Override
    public List<StoryViewModel> getAll() {
        List<Story> stories = _storyRepository.getAll();
        List<StoryViewModel> returnStories = new ArrayList<>();

        for(Story story:stories)
        {
            StoryViewModel tempStory = new StoryViewModel();
            tempStory.setTitle(story.getTitle());
            tempStory.setText(story.getText());
            tempStory.setUserNickName(story.getOwner().getNickName());
            tempStory.setUserAvatar(story.getOwner().getAvatar());
            returnStories.add(tempStory);
        }

        return returnStories;
    }

    @Override
    public Story getById(long id) {
        return _storyRepository.getById(id);
    }

    @Override
    public List<Story> getForUser(long userId) {
        return _storyRepository.getByParameter("owner_id", String.valueOf(userId));
    }
}
