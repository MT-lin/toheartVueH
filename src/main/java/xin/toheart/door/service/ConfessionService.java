package xin.toheart.door.service;

import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.ConfessionHomeDTO;

import java.util.List;

public interface ConfessionService {

    int addConfession(Confession confession);

    int findZanById(int confessorId);

    int updateConssesion(int confessorId, int praiseNum);

    List<ConfessionHomeDTO> getConfessionHomeInfo();
}
