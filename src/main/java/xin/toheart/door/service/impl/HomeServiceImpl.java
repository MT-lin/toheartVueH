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
    public User findUserByOpenid(String openid) {
        return homeMapper.selectUserByOpenId(openid);
    }

    @Override
    public int insertUser(User user) {
        return homeMapper.insertUser(user);
    }
}
