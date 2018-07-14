package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.mapper.ConfessionMapper;
import xin.toheart.door.pojo.Confession;
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
    public List<Confession> findAllConfession() {
        return confessionMapper.findAllConfession();
    }

    @Override
    public int updateConfessionZan(int confessorId) {
        return confessionMapper.updateConfessionZan(confessorId);
    }

    @Override
    public int findZanById(int confessorId) {
        return confessionMapper.findZanById(confessorId);
    }
}
