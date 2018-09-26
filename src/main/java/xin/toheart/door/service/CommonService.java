package xin.toheart.door.service;

import xin.toheart.door.controller.VO.CommentVO;
import xin.toheart.door.pojo.Praise;

import java.util.List;

public interface CommonService {
    Integer getPraiseStatus(int confessorId, int userId,int articleType);

    int setUserPraise(Praise praise);

    int updatePraise(Praise praise);

    int getPraiseNumByPId(int confessorId,int type);

    int setComment(Integer userId, int id, int type,int fatherId, String content);

    List<CommentVO> getCommentList(int id, int type);

    int getCommentNumByPId(int id, int type);
}
