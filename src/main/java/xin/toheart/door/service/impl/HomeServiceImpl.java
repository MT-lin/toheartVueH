package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.mapper.HomeMapper;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.pojo.User;
import xin.toheart.door.service.HomeService;

import java.util.List;

@Service
public class HomeServiceImpl implements HomeService {
    @Autowired
    HomeMapper homeMapper;

    @Override
    public List<Confession> findFiveConfession() {
        return homeMapper.findFiveConfession();
    }

    @Override
    public List<Story> findNewFiveStory() {
        return homeMapper.findNewFiveStory();
    }

    @Override
    public List<Story> findLikeEightStory() {
        return homeMapper.findLikeEightStory();
    }

    @Override
    public Confession findFarConfession() {
        return homeMapper.findFarConfession();
    }

    @Override
    public User findUserByOpenid(String openid) {
        return homeMapper.selectUserByOpenId(openid);
    }
}
