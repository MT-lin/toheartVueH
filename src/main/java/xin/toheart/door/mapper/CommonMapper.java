package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.controller.VO.CommentVO;
import xin.toheart.door.pojo.Praise;

import java.util.List;

public interface CommonMapper {
    Integer getPraiseStatus(@Param("confessorId") int confessorId,@Param("userId") int userId,@Param("articleType") int articleType);

    int setUserPraise(@Param("praise") Praise praise);

    int updatePraise(@Param("praise") Praise praise);

    int getPraiseNumByPId(@Param("confessorId") int confessorId,@Param("type") int type);

    int setComment(@Param("userId") Integer userId,@Param("id")  int id,@Param("type")   int type,@Param("fatherId") int fatherId,@Param("content")  String content);

    List<CommentVO> getCommentList(@Param("articleId") int id,@Param("articleType") int articleType);

    List<CommentVO> getCommentChild(int commentId);

    int getCommentNumByPId(@Param("id") int id, @Param("type") int type);
}
