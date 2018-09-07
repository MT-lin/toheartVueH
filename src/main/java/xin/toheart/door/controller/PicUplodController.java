package xin.toheart.door.controller;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xin.toheart.door.common.util.FtpUplodUtil;

import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/pic")
public class PicUplodController {
    Logger LOGGER = LoggerFactory.getLogger(ConfessionController.class);

    @Autowired
    FtpUplodUtil ftpUplodUtil;
    @Value("${ftp.host}")
    String host;
    @Value("${ftp.port}")
    Integer port;
    @Value("${ftp.username}")
    String username;
    @Value("${ftp.password}")
    String password;
    @Value("${ftp.path}")
    String path;

    /**
     * 上传文件
     */
    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam(value="file",required=false) MultipartFile img){
        Map<String,Object> result = new HashMap<>();
        try {
            //1.初始化文件上传工具类
            ftpUplodUtil.init(host, port, username, password);
            //2.上传文件
            String imageUrl = ftpUplodUtil.upload(path, img.getOriginalFilename(),
                    img.getInputStream());
            result.put("ok",true);
            result.put("data", imageUrl);
        } catch (Exception e) {
            result.put("ok",false);
            result.put("msg","上传图片出现异常");
        }
        return new Gson().toJson(result);
    }

}
