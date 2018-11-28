package xin.toheart.door.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.toheart.door.controller.VO.AccountBookVO;
import xin.toheart.door.mapper.AccountBookMapper;
import xin.toheart.door.pojo.AccountBook;
import xin.toheart.door.service.AccountBookService;

import java.util.List;

@Service
public class AccountBookServiceImpl implements AccountBookService {
    @Autowired
    AccountBookMapper accountBookMapper;
    @Override
    public int setAccountBook(AccountBook accountBook) {
        return accountBookMapper.setAccountBook(accountBook);
    }

    @Override
    public List<AccountBookVO> getBookByUser(Integer userId) {
        return accountBookMapper.getBookByUser(userId);
    }

    @Override
    public int setAccountBookAndUser(int accountBookId, int userId) {
        return accountBookMapper.setAccountBookAndUser(accountBookId,userId);
    }
}
