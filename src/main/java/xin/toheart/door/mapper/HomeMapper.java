package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.pojo.User;

import java.util.List;

public interface HomeMapper {
    List<Confession> findFiveConfession();

    List<Story> findNewFiveStory();

    List<Story> findLikeEightStory();

    Confession findFarConfession();

    User selectUserByOpenId(String openid);

    int insertUser(@Param("user") User user);
}
