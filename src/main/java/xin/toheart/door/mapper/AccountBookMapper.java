package xin.toheart.door.mapper;

import org.apache.ibatis.annotations.Param;
import xin.toheart.door.controller.VO.AccountBookVO;
import xin.toheart.door.pojo.AccountBook;

import java.util.ArrayList;

public interface AccountBookMapper {
    int setAccountBook(AccountBook accountBook);

    ArrayList<AccountBookVO> getBookByUser(Integer userId);

    int setAccountBookAndUser(@Param("accountBookId") int accountBookId,@Param("userId") int userId);
}
