package xin.toheart.door.service;

import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.pojo.Story;

import java.util.List;

public interface StoryService {
    int saveStory(Story story);

    Story findStoryById(int id);

    List<Story> findAllStory(PageUtil pageBean);

    List<Story> findStoryByLike();

    List<Story> findLikeEightStory();

    int totalCount();

    int updateStoryLike(int id, int praiseNum);

    int updateStoryCommentNum(int id, int commentNum);
}
