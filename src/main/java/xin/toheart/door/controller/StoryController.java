package xin.toheart.door.controller;

import jdk.nashorn.internal.ir.RuntimeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.mapper.StoryMapper;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.service.CommonService;
import xin.toheart.door.service.ConfessionService;
import xin.toheart.door.service.StoryService;
import com.google.common.base.Strings;
import xin.toheart.door.common.enumType.PraiseStatusEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/story")
public class StoryController extends BaseController{
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);

    @Autowired
    StoryService storyService;

    @Autowired
    CommonService commonService;


    @RequestMapping(value = "/saveStory",method = RequestMethod.POST)
    public ResponseDto saveStory(@RequestBody Story story){
        System.out.println(story.getStoryTitle().length());
        HashMap map = new HashMap();
        if (Strings.isNullOrEmpty(story.getStoryAutor())) {
            return fail(map,"请填写作者名");
        }else if (story.getStoryBrief().length() <10){
            return fail(map,"故事简介不能少于十个字");
        }else if (story.getStoryContent().length() < 100){
            return fail(map,"故事内容过少，请认真点");
        }else if (Strings.isNullOrEmpty(story.getStoryImgUrl())){
            return fail(map,"请上传封面");
        }else if (Strings.isNullOrEmpty(story.getStoryTitle())||story.getStoryTitle().length()>20){
            return fail(map,"题目不能超过20个字或者为空");
        }
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
            int praiseNum = commonService.getPraiseNumByPId(id,PraiseStatusEnum.NOPRAISE.getCode());
            story.setStoryZan(praiseNum);
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
