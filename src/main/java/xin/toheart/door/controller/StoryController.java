package xin.toheart.door.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import xin.toheart.door.common.util.PageUtil;
import xin.toheart.door.mapper.StoryMapper;
import xin.toheart.door.pojo.Story;
import xin.toheart.door.service.StoryService;

import java.util.List;

@Controller
@RequestMapping("/story")
public class StoryController {
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);

    @Autowired
    StoryService storyService;

    @RequestMapping(method = RequestMethod.GET)
    public String getStory(){
        return "story/storyWriter";
    }

    @RequestMapping("/saveStory")
    public String saveStory(Story story){
        int temp=storyService.saveStory(story);
        return "story/storyShow";
    }
    @RequestMapping(value = "/showStory/{id}",method = RequestMethod.GET)
    public String showStory(@PathVariable("id") int id, ModelMap map){
        Story story = storyService.findStoryById(id);
        map.put("story",story);
        return "story/storyShow";
    }
    @RequestMapping(value = "storyHome/{index}/{size}",method = RequestMethod.GET)
    public String storyHome(ModelMap map ,@PathVariable("size") String size,@PathVariable("index") String index){
        PageUtil<Story> pageBean = PageUtil.getPageBean(index ,size);
        pageBean.setTotalCount(storyService.totalCount());
        System.out.println(pageBean.toString());
        List<Story> storyList = storyService.findAllStory(pageBean);
        List<Story> storyLileList = storyService.findStoryByLike();
        map.addAttribute("pageBean",pageBean);
        map.addAttribute("storyLileList",storyLileList);
        map.addAttribute("storyList",storyList);
        return "story/storyHome";
    }
}
