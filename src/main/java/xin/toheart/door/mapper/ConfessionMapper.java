package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.ConfessionHomeDTO;

import java.util.List;

public interface ConfessionMapper {


    int addConfession(@Param("confession") Confession confession);

    int findZanById(int confessorId);

    int updateConssesion(int confessorId, int praiseNum);

    Confession findFarConfession();

    int totalCount();

    List<Confession> getConfessionList(@Param("start") int start,@Param("size") int size);
}
