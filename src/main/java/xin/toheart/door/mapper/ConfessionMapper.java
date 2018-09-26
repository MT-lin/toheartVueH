package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.controller.VO.ConfessionVO;
import xin.toheart.door.pojo.Confession;

import java.util.List;

public interface ConfessionMapper {


    int addConfession(@Param("confession") Confession confession);

    int findZanById(int confessorId);

    int updateConssesion(@Param("confessorId") int confessorId,@Param("praiseNum") int praiseNum);

    ConfessionVO findFarConfession();

    int totalCount();

    List<ConfessionVO> getConfessionList(@Param("start") int start, @Param("size") int size);

    ConfessionVO getConfessionById(String id);

    int updateConssesionCommentNum(@Param("confessorId") int id,@Param("commentNum") int commentNum);
}
