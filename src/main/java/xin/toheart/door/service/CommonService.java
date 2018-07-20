package xin.toheart.door.service;

import xin.toheart.door.pojo.Praise;

import java.util.List;

public interface CommonService {
    Integer getPraiseStatus(int confessorId, int userId,int articleType);

    int setUserPraise(Praise praise);

    int updatePraise(Praise praise);

    int getPraiseNumByPId(int confessorId);
}
