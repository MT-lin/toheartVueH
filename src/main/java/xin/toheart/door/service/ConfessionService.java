package xin.toheart.door.service;

import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.controller.VO.ConfessionVO;
import xin.toheart.door.pojo.Confession;

import java.util.List;

public interface ConfessionService {

    int addConfession(Confession confession);

    int findZanById(int confessorId);

    int updateConssesion(int confessorId, int praiseNum);

    ConfessionVO findFarConfession();

    int totalCount();

    List<ConfessionVO> getConfessionList(PageUtil<Confession> pageBean);

    ConfessionVO getConfessionById(String id);

    int updateConssesionCommentNum(int id, int commentNum);
}
