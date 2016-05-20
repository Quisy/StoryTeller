package com.quisy.repositories.implementations;

import com.quisy.models.Story;
import com.quisy.repositories.interfaces.IStoryDAO;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by lampr on 18.05.2016.
 */

@Repository
@Transactional
public class StoryDAO extends BaseDAO<Story> implements IStoryDAO<Story> {
    public StoryDAO() {
        super(Story.class);
    }
}
