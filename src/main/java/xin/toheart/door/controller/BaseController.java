package xin.toheart.door.controller;

import xin.toheart.door.common.constant.CommonsConstant;
import xin.toheart.door.dto.ResponseDto;
import xin.toheart.door.pojo.User;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Administrator on 2018/9/3.
 */
public class BaseController {

    public ResponseDto success(){
        ResponseDto dto = new ResponseDto();
        dto.setCode(20000);
        dto.setState(true);
        return  dto;
    }
    public ResponseDto success(Map data){
        ResponseDto dto = new ResponseDto();
        dto.setCode(20000);
        dto.setData(data);
        dto.setState(true);
        return  dto;
    }
    public ResponseDto success(Map data,String msg){
        ResponseDto dto = new ResponseDto();
        dto.setCode(20000);
        dto.setData(data);
        dto.setState(true);
        if(!msg.isEmpty()){
            dto.setMessage(msg);
        }
        return  dto;
    }
    public ResponseDto fail(){
        ResponseDto dto = new ResponseDto();
        dto.setCode(44444);
        dto.setState(false);
        return dto;
    }
    public ResponseDto fail(Map data){
        ResponseDto dto = new ResponseDto();
        dto.setCode(44444);
        dto.setData(data);
        dto.setState(false);
        return dto;
    }
    public ResponseDto fail(Map data,String msg){
        ResponseDto dto = new ResponseDto();
        dto.setCode(44444);
        dto.setData(data);
        dto.setState(false);
        if(!msg.isEmpty()){
            dto.setMessage(msg);
        }
        return  dto;
    }

    public User getCurrentUser( HttpSession session) {
        User user  = (User)session.getAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
        return user;
    }
}
