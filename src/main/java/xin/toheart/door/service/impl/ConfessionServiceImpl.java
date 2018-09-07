package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.mapper.ConfessionMapper;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.ConfessionHomeDTO;
import xin.toheart.door.service.ConfessionService;

import java.util.List;

@Service
public class ConfessionServiceImpl implements ConfessionService {
    @Autowired
    ConfessionMapper confessionMapper;

    @Override
    public int addConfession(Confession confession) {
        return confessionMapper.addConfession(confession);
    }

    @Override
    public int findZanById(int confessorId) {
        return confessionMapper.findZanById(confessorId);
    }

    @Override
    public int updateConssesion(int confessorId, int praiseNum) {
        return confessionMapper.updateConssesion(confessorId,praiseNum);
    }

    @Override
    public Confession findFarConfession() {
        return confessionMapper.findFarConfession();
    }

    @Override
    public int totalCount() {
        return confessionMapper.totalCount();
    }

    @Override
    public List<Confession> getConfessionList(PageUtil<Confession> pageBean) {
        int start = pageBean.getStartRow();
        int size = pageBean.getSize();
        return confessionMapper.getConfessionList(start,size);
    }


}
