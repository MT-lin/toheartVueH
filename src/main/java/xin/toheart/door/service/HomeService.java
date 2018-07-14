package xin.toheart.door.service;

import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;

import java.util.List;

public interface HomeService {
    List<Confession> findFiveConfession();

    List<Story> findNewFiveStory();

    List<Story> findLikeEightStory();

    Confession findFarConfession();
}
