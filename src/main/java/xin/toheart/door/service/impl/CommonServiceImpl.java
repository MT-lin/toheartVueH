package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.controller.VO.CommentVO;
import xin.toheart.door.mapper.CommonMapper;
import xin.toheart.door.pojo.Praise;
import xin.toheart.door.service.CommonService;

import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {
    @Autowired
    CommonMapper commonMapper;

    @Override
    public Integer getPraiseStatus(int confessorId, int userId,int articleType) {
        return commonMapper.getPraiseStatus(confessorId, userId,articleType);
    }

    @Override
    public int setUserPraise(Praise praise) {
        return commonMapper.setUserPraise(praise);
    }

    @Override
    public int updatePraise(Praise praise) {
        return commonMapper.updatePraise(praise);
    }

    @Override
    public int getPraiseNumByPId(int confessorId,int type) {
        return commonMapper.getPraiseNumByPId(confessorId,type);
    }

    @Override
    public int setComment(Integer userId, int id, int type,int fatherId, String content) {
        return commonMapper.setComment(userId,id,type,fatherId,content);
    }

    @Override
    public List<CommentVO> getCommentList(int id, int type) {
        return commonMapper.getCommentList(id,type);
    }

    @Override
    public int getCommentNumByPId(int id, int type) {
        return commonMapper.getCommentNumByPId(id,type);
    }

}
