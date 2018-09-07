package xin.toheart.door.service;

import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.pojo.User;

import java.util.List;

public interface HomeService {
    User findUserByOpenid(String openid);

    int insertUser(User user);
}
