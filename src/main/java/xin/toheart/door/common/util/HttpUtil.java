package xin.toheart.door.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * QQ登录HTTp请求
 *
 */
@Configuration
public class HttpUtil {
    /**
     * 获取access_token
     * @param code
     * @return
     */
    public static String getAccessToken(String code){
        String requestURL = "https://graph.qq.com/oauth2.0/token";
        ConcurrentHashMap<String,String> requestParam = new ConcurrentHashMap();
        requestParam.put("grant_type","authorization_code");
        requestParam.put("client_id","101484099");
        requestParam.put("client_secret","fff967fe64a65d6fc318b5e5c22e6cd5");
        requestParam.put("code",code);
        requestParam.put("redirect_uri","http://www.toheart.xin/QQLogin");
        String result=sentGET(requestURL,requestParam);
        String token=result.substring(result.indexOf("=")+1,result.indexOf("&"));
        return token;
    }

    /**
     * 获取用户的OpenId
     * @param access_token
     * @return
     */
    public static String  getOpenId(String access_token){
        String requestURL="https://graph.qq.com/oauth2.0/me";
        ConcurrentHashMap<String,String> requestParam = new ConcurrentHashMap();
        requestParam.put("access_token",access_token);
        String result= sentGET(requestURL,requestParam);
        String openId=result.substring(result.indexOf("openid")+9,result.lastIndexOf("\""));
        return openId;
    }

    public static JSONObject getUserInfo(String openId,String accessToken){
        String requestURL = "https://graph.qq.com/user/get_user_info";
        ConcurrentHashMap<String,String> requestParam = new ConcurrentHashMap();
        requestParam.put("access_token",accessToken);
        requestParam.put("oauth_consumer_key","101484099");
        requestParam.put("openid",openId);
        JSONObject result=JSONObject.parseObject(sentGET(requestURL,requestParam));
        return result;
    }
    /**
     * 发送Get请求
     * @param requestURL
     * @param requestParam
     * @return
     */
    private static String sentGET(String requestURL, ConcurrentHashMap<String, String> requestParam) {
        String result = "";
        BufferedReader in = null;
        String param="";
        try {
            Iterator<String> it=requestParam.keySet().iterator();
            while (it.hasNext()){
                String key=it.next();
                param +=key+"="+requestParam.get(key)+"&";
            }
            String urlNameString = requestURL + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;

    }
}
