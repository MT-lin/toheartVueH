package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.pojo.Confession;

import java.util.List;

public interface ConfessionMapper {


    int addConfession(@Param("confession") Confession confession);

    List<Confession> findAllConfession();

    int updateConfessionZan(int confessorId);

    int findZanById(int confessorId);
}
