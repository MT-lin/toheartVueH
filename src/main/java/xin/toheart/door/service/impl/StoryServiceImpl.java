package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.mapper.StoryMapper;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.service.StoryService;

import java.util.List;

@Service
public class StoryServiceImpl implements StoryService{
    @Autowired
    StoryMapper storyMapper;

    @Override
    public int saveStory(Story story) {
        return storyMapper.insertStory(story);
    }

    @Override
    public Story findStoryById(int id) {
        return storyMapper.findStoryById(id);
    }

    @Override
    public List<Story> findAllStory(PageUtil pageBean) {
        int start = pageBean.getStartRow();
        System.out.println("--------------"+start);
        int size = pageBean.getSize();
        System.out.println("--------------"+size);
        return storyMapper.findAllStory(start,size);
    }

    @Override
    public List<Story> findStoryByLike() {
        return storyMapper.findStoryByLike();
    }

    @Override
    public int totalCount() {
        return storyMapper.findTotalCount();
    }
}
