package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.mapper.StoryMapper;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.service.StoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/story")
public class StoryController extends BaseController{
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);

    @Autowired
    StoryService storyService;


    @RequestMapping("/saveStory")
    public ResponseDto saveStory(Story story){
        try {
            int temp=storyService.saveStory(story);
        }catch (Exception e){
            return fail();
        }

        return success();
    }
    @RequestMapping(value = "/showStory/{id}",method = RequestMethod.GET)
    public ResponseDto showStory(@PathVariable("id") int id){
        HashMap data = new HashMap();
        try {
            Story story = storyService.findStoryById(id);
            data.put("story",story);
        }catch (Exception e){
            return fail();
        }
        return success(data);
    }

    @RequestMapping(value = "storyList/{index}/{size}",method = RequestMethod.GET)
    public ResponseDto storyList(@PathVariable("index") String index,@PathVariable("size") String size){
        PageUtil<Story> pageBean = PageUtil.getPageBean(index ,size);
        int totalCount = storyService.totalCount();
        pageBean.setTotalCount(totalCount);

        List<Story> storyList = storyService.findAllStory(pageBean);
        Map data = new HashMap();
        data.put("storyList",storyList);
        data.put("total",totalCount);
        return success(data);
    }

    @RequestMapping("/splendidStory/inHome")
    public ResponseDto splendidStoryInHome(){
        HashMap data = new HashMap();
        try {
            List<Story> storySplendidList = storyService.findLikeEightStory();
            data.put("storySplendidList",storySplendidList);
        }catch (Exception e){
            return fail(data,"/splendidStory/inHome出现异常");
        }
        return success(data);
    }
}
