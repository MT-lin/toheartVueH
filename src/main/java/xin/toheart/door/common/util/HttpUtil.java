package xin.toheart.door.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        requestParam.put("redirect_uri","http://www.toheart.xin:5201/QQLogin");
        String result=sentGET(requestURL,requestParam);
        String token=result.substring(result.indexOf("=")+1,result.indexOf("&"));
        System.out.println("token:"+result);
        System.out.println("token2:"+result);
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
        System.out.println("openId1:"+result);
        String openId=result.substring(result.indexOf("openid")+9,result.lastIndexOf("\""));
        System.out.println("openId2:"+openId);
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
    public static String sentGET(String requestURL, ConcurrentHashMap<String, String> requestParam) {
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
    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    /**
     * get请求
     *
     * @return
     */
    public static String doGet(String url) {
        try {
            HttpClient client = new DefaultHttpClient();
            //发送get请求
            HttpGet request = new HttpGet(url);
            HttpResponse response = client.execute(request);

            /**请求发送成功，并得到响应**/
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == HttpStatus.SC_OK) {
                /**读取服务器返回过来的json字符串数据**/
                String strResult = EntityUtils.toString(response.getEntity(), "utf-8");
                logger.info("\nget={} \nresult={}", url, strResult);
                return strResult;
            } else {
                logger.info("\nget={} \ncode={}", url, statusCode);
            }
        } catch (IOException e) {
            logger.error("get={} error ", url, e);
        }

        return null;
    }
}
