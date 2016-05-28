package com.quisy.controllers;

import com.quisy.models.Story;
import com.quisy.services.interfaces.IStoryService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Story> getAll() {
        List<Story> stories = _storyService.getAll();
        return stories;
    }

    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
    @ResponseBody
    public String getById(@PathVariable(value="id") int id) {
        return "dupa";
    }

//    @RequestMapping(value="/get/{id}", method=RequestMethod.GET)
//    @ResponseBody
//    public String getById(@PathVariable(value="id") int id) {
//        return "dupa";
//    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Story add(@RequestBody Story story) {
        _storyService.create(story);
        return story;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Story update(@RequestBody Story story) {

        _storyService.update(story);
        return story;
    }




}
