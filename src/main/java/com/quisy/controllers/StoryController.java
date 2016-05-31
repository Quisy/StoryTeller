package com.quisy.controllers;

import com.quisy.models.Story;
import com.quisy.models.StoryAddViewModel;
import com.quisy.models.StoryViewModel;
import com.quisy.services.interfaces.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lampr on 20.05.2016.
 */

@RestController
@RequestMapping(value="/api/story")
public class StoryController {

    private final IStoryService<Story> _storyService;

    @Autowired
    public StoryController(IStoryService<Story> storyService) {
        _storyService = storyService;
    }


    @RequestMapping(value="/get", method=RequestMethod.GET)
    @ResponseBody
    public List<StoryViewModel> getAll() {
        return _storyService.getAll();
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable(value="id") int id) {
        return "xx";
    }

    @RequestMapping(value="/getUsers/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Story> getUsersStories(@PathVariable(value="id") long userId) {
        return _storyService.getForUser(userId);
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity add(@RequestBody StoryAddViewModel story) {
        try{
            _storyService.create(story);
            return  ResponseEntity.ok(null);
        }
        catch(Exception ex)
        {
            return (ResponseEntity) ResponseEntity.notFound();
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Story update(@RequestBody Story story) {

        _storyService.update(story);
        return story;
    }




}
