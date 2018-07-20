package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.ConfessionHomeDTO;
import xin.toheart.door.pojo.Praise;
import xin.toheart.door.service.CommonService;
import xin.toheart.door.service.ConfessionService;

import java.util.List;

@Controller
@RequestMapping("/confession")
public class ConfessionController {

    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);
    @Autowired
    ConfessionService confessionService;
    @Autowired
    CommonService commonService;

    @RequestMapping(method = RequestMethod.GET )
    public String home(ModelMap map){
       List<ConfessionHomeDTO> list = confessionService.getConfessionHomeInfo();//获取表白内容
       map.addAttribute("confessionList",list);
       return "confession/confessionHome";
    }
    @RequestMapping("/addConfession")
    public String addConfession(@ModelAttribute Confession confession){
        int temp=confessionService.addConfession(confession);
        return "redirect:/confession";
    }
}
