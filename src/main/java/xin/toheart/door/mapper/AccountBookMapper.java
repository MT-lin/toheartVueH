package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.controller.VO.AccountBookVO;
import xin.toheart.door.pojo.AccountBook;
import xin.toheart.door.pojo.User;

import java.util.ArrayList;

public interface AccountBookMapper {
    int setAccountBook(@Param("accountBook") AccountBook accountBook);

    ArrayList<AccountBookVO> getBookByUser(Integer userId);
}
