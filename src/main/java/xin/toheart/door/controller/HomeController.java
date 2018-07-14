package xin.toheart.door.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.toheart.door.common.util.HttpUtil;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.service.HomeService;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    HomeService homeService;

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap map){
        List<Confession> confessionList = homeService.findFiveConfession();
        List<Story> storyNewFiveList = homeService.findNewFiveStory();
        List<Story> storyLikeEightList = homeService.findLikeEightStory();
        Confession farConfession = homeService.findFarConfession();
        map.addAttribute("farConfession",farConfession);
        map.addAttribute("storyLikeEightList",storyLikeEightList);
        map.addAttribute("confessionList",confessionList);
        map.addAttribute("storyNewFiveList",storyNewFiveList);
        return "home";
    }
    @RequestMapping("/login")
    public String login(){
        return "redirect:https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=101484099&redirect_uri=http://www.toheart.xin/QQLogin&state=test";
    }
    @RequestMapping("/QQLogin")
    public String QQLogin(String code){
        String accessToken=HttpUtil.getAccessToken(code);
        String openid = HttpUtil.getOpenId(accessToken);
        JSONObject userInfo = HttpUtil.getUserInfo(accessToken,openid);
        return "redirect:/";
    }

}