package xin.toheart.door.service;

import xin.toheart.door.controller.VO.AccountBookVO;
import xin.toheart.door.pojo.AccountBook;
import xin.toheart.door.pojo.User;

import java.util.ArrayList;
import java.util.List;

public interface AccountBookService {
    int setAccountBook(AccountBook accountBook);

    List<AccountBookVO> getBookByUser(Integer userId);
}
