package xin.toheart.door.controller;

import com.google.common.base.Strings;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xin.toheart.door.common.constant.CommonsConstant;
import xin.toheart.door.common.enumType.ArticleTypeEnum;
import xin.toheart.door.common.enumType.PraiseStatusEnum;
import xin.toheart.door.controller.VO.CommentVO;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.pojo.Comment;
import xin.toheart.door.pojo.Praise;
import xin.toheart.door.pojo.User;
import xin.toheart.door.service.CommonService;
import xin.toheart.door.service.ConfessionService;
import xin.toheart.door.service.StoryService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/common")
public class CommonController extends BaseController{
    org.slf4j.Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);
    @Autowired
    CommonService commonService;
    @Autowired
    ConfessionService confessionService;
    @Autowired
    StoryService storyService;
    @RequestMapping("/increaseZan")
    public ResponseDto increaseZan(int id,int type, HttpSession session){
        Praise praise = null;
       Map<String,Integer> map = new HashMap<>();
       //从session中获取当前用户的userId
        User user  = (User)session.getAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
        Integer userId = user.getUserId();
        LOGGER.info("userId:---"+userId);
       //查询点赞状态status null--》没有这个人的赞  0---》这个人没有点赞  1---》这个人点赞了
        Integer status = commonService.getPraiseStatus(id,userId,type);
        LOGGER.info("status:---"+status);
        if(status == null||"".equals(status)){
           praise = new Praise(id, type,userId, PraiseStatusEnum.NOPRAISE.getCode(),new Date());
            int userPr = commonService.setUserPraise(praise);
            LOGGER.info("userPr:---"+userPr);
        }else if(status == PraiseStatusEnum.NOPRAISE.getCode()){
            praise = new Praise(id, type,userId, PraiseStatusEnum.PRAISE.getCode());
            LOGGER.info("updateTemp1praise:---"+praise);
            int updateTemp = commonService.updatePraise(praise);
            LOGGER.info("updateTemp1:---"+updateTemp);
        }else {
            praise = new Praise(id, type,userId, PraiseStatusEnum.NOPRAISE.getCode());
            LOGGER.info("updateTemp2praise:---"+praise);
            int updateTemp = commonService.updatePraise(praise);
            LOGGER.info("updateTemp2:---"+updateTemp);
        }
        //查询该文章的点赞总数
        int praiseNum = commonService.getPraiseNumByPId(id,type);
        //修改表白的点赞总数
        if (type==ArticleTypeEnum.WHITE_WALL.getCode()) {
            int updateConssesion = confessionService.updateConssesion(id,praiseNum);
        }else if(type==ArticleTypeEnum.STORY.getCode()){
            int updateStoryLike = storyService.updateStoryLike(id,praiseNum);
        }
        map.put("praiseNum",praiseNum);
        map.put("status",status);
        return success(map);

    }

    @RequestMapping("/increaseComment")
    public ResponseDto increaseComment(int id,int type,int fatherId,String content, HttpSession session){
        Map<String,Integer> map = new HashMap<>();
        if (Strings.isNullOrEmpty(content)) {
            return fail(map,"评论内容不能为空");
        }
        Comment comment = null;

        //从session中获取当前用户的userId
        User user  = (User)session.getAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
        Integer userId = user.getUserId();
        LOGGER.info("userId:---"+userId);
        try{
            int commnetId = commonService.setComment(userId,id,type,fatherId,content);
            int commentNum =  commonService.getCommentNumByPId(id,type);
            if(type == ArticleTypeEnum.WHITE_WALL.getCode()){
                int updateConssesion = confessionService.updateConssesionCommentNum(id,commentNum);
            }else if(type == ArticleTypeEnum.STORY.getCode()){
                int updateStoryCommentNum = storyService.updateStoryCommentNum(id,commentNum);
            }
            map.put("commnetId",commnetId);
        }catch (Exception e){
            return fail();
        }
        return success(map);
    }
    @RequestMapping("/findComment")
    public ResponseDto findComment(int id,int type){
        HashMap data = new HashMap();
        try {
            List<CommentVO> commentList =  commonService.getCommentList(id,type);
            data.put("commentList",commentList);
            return success(data);
        }catch (Exception e){
            return fail();
        }
    }

}