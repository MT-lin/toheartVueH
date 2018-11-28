package xin.toheart.door.controller;

import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.toheart.door.controller.VO.AccountBookVO;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.pojo.AccountBook;
import xin.toheart.door.pojo.User;
import xin.toheart.door.service.AccountBookService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/account")
public class AccountBookController extends BaseController{
    @Autowired
    AccountBookService accountBookService;
    /**
     * 创建记账本
     * @return
     */
    @RequestMapping("/book/create")
    public ResponseDto bookCreate(AccountBook accountBook, HttpSession session) {
        Map data = new HashMap();
        if(Strings.isNullOrEmpty(accountBook.getBookName())){
            return fail(data,"记账本名称不能为空");
        }else if(Strings.isNullOrEmpty(accountBook.getCommand())) {
            return fail(data,"口令不能为空");
        }
        try{
            User user = getCurrentUser(session);
            // accountBook.setUserId(user.getUserId());
            accountBook.setUserId(3);
            int id = accountBookService.setAccountBook(accountBook);
            System.out.println(accountBook.toString());
            int temp = accountBookService.setAccountBookAndUser(accountBook.getId(),3);
        }catch (Exception e) {
            return fail(data,"创建记账本失败");
        }
        return success();
    }
    @RequestMapping("/book/get")
    public ResponseDto getBook( HttpSession session) {
        Map data = new HashMap();
        User user = getCurrentUser(session);
        List<AccountBookVO> list = accountBookService.getBookByUser(3);
       //  ArrayList<AccountBookVO> list = accountBookService.getBookByUser(user.getUserId());
        data.put("bookList", list);
        return success(data);
    }
}
