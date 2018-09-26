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
        int size = pageBean.getSize();
        return storyMapper.findAllStory(start,size);
    }

    @Override
    public List<Story> findStoryByLike() {
        return storyMapper.findStoryByLike();
    }

    @Override
    public List<Story> findLikeEightStory() {
        return storyMapper.findLikeEightStory();
    }

    @Override
    public int totalCount() {
        return storyMapper.findTotalCount();
    }

    @Override
    public int updateStoryLike(int id, int praiseNum) {
        return storyMapper.updateStoryLike(id,praiseNum);
    }

    @Override
    public int updateStoryCommentNum(int id, int commentNum) {
        return storyMapper.updateStoryCommentNum(id,commentNum);
    }
}
