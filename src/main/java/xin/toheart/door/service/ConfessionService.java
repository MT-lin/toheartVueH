package xin.toheart.door.service;

import xin.toheart.door.pojo.Confession;

import java.util.List;

public interface ConfessionService {

    int addConfession(Confession confession);

    List<Confession> findAllConfession();

    int updateConfessionZan(int confessorId);

    int findZanById(int confessorId);
}
