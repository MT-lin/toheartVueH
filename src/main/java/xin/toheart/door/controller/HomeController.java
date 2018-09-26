package xin.toheart.door.controller;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xin.toheart.door.annonation.TimeCostAnnotation;
import xin.toheart.door.common.constant.CommonsConstant;
import xin.toheart.door.common.util.DateUtil;
import xin.toheart.door.common.util.HttpUtil;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.pojo.User;
import xin.toheart.door.service.HomeService;
import xin.toheart.door.web.session.SessionProvider;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController extends BaseController{
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);
    @Autowired
    HomeService homeService;

    @Autowired
    private SessionProvider sessionProvider;


    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public ResponseDto logout(HttpSession session){
        session.removeAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
        return success();
    }

    /**
     * QQ登录
     * @return
     */
    @RequestMapping("/login")
    public String login(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101484099&redirect_uri=http://www.toheart.xin:5201/QQLogin&state=test");
        return "redirect";
    }

    /**
     * QQ登录回调接口
     * @param code
     * @param session
     * @return
     * @throws ParseException
     */
    @RequestMapping("/QQLogin")
    public String QQLogin(String code,HttpSession session,HttpServletResponse response) throws ParseException, IOException {
        System.out.println(code);
        String accessToken=HttpUtil.getAccessToken(code);
        String openid = HttpUtil.getOpenId(accessToken);
        JSONObject userInfo = HttpUtil.getUserInfo(openid,accessToken);
        User isUser=homeService.findUserByOpenid(openid);
        System.out.println(isUser==null);
        if(isUser==null){
            User user = new User();
            user.setBirthday(new Date(DateUtil.stringToData((String)userInfo.get("year"),"yy").getTime()));
            user.setCity((String)userInfo.get("city"));
            user.setGender((String)userInfo.get("gender"));
            user.setImgUrl((String)userInfo.get("figureurl_2"));
            user.setProvince((String)userInfo.get("province"));
            user.setUserName((String)userInfo.get("nickname"));
            user.setOpenid(openid);
            int temp = homeService.insertUser(user);
            session.setAttribute(CommonsConstant.UserConstant.CURRENT_BUYER,user);

        }else {
            session.setAttribute( CommonsConstant.UserConstant.CURRENT_BUYER,isUser);
        }
        //JSONObject userInfo = HttpUtil.getUserInfo(accessToken,openid);
        response.sendRedirect("http://www.toheart.xin");
        return "登录成功";
    }

    /**
     * 从session中获取user
     * @return
     */
    @RequestMapping("/user")
    public ResponseDto getUser(ModelMap map,HttpSession session){
        User user=(User) session.getAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
        map.put("user",user);
        return success(map);
    }
}
