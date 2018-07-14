package xin.toheart.door.mapper;

import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;

import java.util.List;

public interface HomeMapper {
    List<Confession> findFiveConfession();

    List<Story> findNewFiveStory();

    List<Story> findLikeEightStory();

    Confession findFarConfession();
}
