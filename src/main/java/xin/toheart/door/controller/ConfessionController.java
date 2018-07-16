package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.service.ConfessionService;

import java.util.List;

@Controller
@RequestMapping("/confession")
public class ConfessionController {

    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);
    @Autowired
    ConfessionService confessionService;

    @RequestMapping(method = RequestMethod.GET )
    public String home(ModelMap map){
       List<Confession> list = confessionService.findAllConfession();
       map.addAttribute("confessionList",list);
       return "confession/confessionHome";
    }
    @RequestMapping("/addConfession")
    public String addConfession(@ModelAttribute Confession confession){
        int temp=confessionService.addConfession(confession);
        return "redirect:/confession";
    }
    @RequestMapping("/increaseZan")
    @ResponseBody
    public  String increaseZan(int confessorId){
        int temp=confessionService.updateConfessionZan(confessorId);
        int zan = confessionService.findZanById(confessorId);
        return zan+"";

    }


}
