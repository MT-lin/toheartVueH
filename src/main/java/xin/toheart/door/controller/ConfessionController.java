package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.pojo.Confession;
import xin.toheart.door.pojo.ConfessionHomeDTO;
import xin.toheart.door.pojo.Praise;
import xin.toheart.door.service.CommonService;
import xin.toheart.door.service.ConfessionService;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/confession")
public class ConfessionController extends BaseController{

    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);
    @Autowired
    ConfessionService confessionService;
    @Autowired
    CommonService commonService;


    @RequestMapping("/addConfession")
    public String addConfession(@ModelAttribute Confession confession){
        int temp=confessionService.addConfession(confession);
        return "redirect:/confession";
    }

    /**
     *首页展示点赞最多的告白
     * @return
     */
    @RequestMapping("/splendidConfession/inHome")
    public ResponseDto splendidConfession(){
        HashMap data = new HashMap();
        try{
            Confession farConfession = confessionService.findFarConfession();
            data.put("farConfession",farConfession);
        }catch (Exception e){
            return fail(data,"confession/splendidConfession查询点赞最多告白异常");
        }
        return success(data);
    }

    @RequestMapping("/confessionList/{index}/{size}")
    public ResponseDto confessionList(@PathVariable("index") String index ,@PathVariable("size") String size){
        HashMap data = new HashMap();
        try {
            PageUtil<Confession> pageBean = PageUtil.getPageBean(index ,size);
            pageBean.setTotalCount(confessionService.totalCount());
            List<Confession> confessionList = confessionService.getConfessionList(pageBean);
            data.put("confessionList",confessionList);
        }catch (Exception e){
            return fail(data,"获取告白列表失败");
        }

        return success(data);
    }
}
