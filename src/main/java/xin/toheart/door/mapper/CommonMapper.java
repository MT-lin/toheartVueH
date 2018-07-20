package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.pojo.Praise;

import java.util.List;

public interface CommonMapper {
    Integer getPraiseStatus(@Param("confessorId") int confessorId,@Param("userId") int userId,@Param("articleType") int articleType);

    int setUserPraise(@Param("praise") Praise praise);

    int updatePraise(@Param("praise") Praise praise);

    int getPraiseNumByPId(int confessorId);
}
