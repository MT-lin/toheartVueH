package xin.toheart.door;

import com.alibaba.fastjson.JSONObject;
import xin.toheart.door.common.util.DateUtil;
import xin.toheart.door.common.util.HttpUtil;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class URLTest {
    public static void main(String[] args) throws ParseException {
//        String tean=HttpUtil.getAccessToken("5E79556BEB59279861EF8B6E5B3FA994");
//        System.out.println(tean);
        //JSONObject open = HttpUtil.getOpenId("854F4EE6931B17857BCD64B3CE22A88E");
      //  System.out.println(open.get("openid"));
        JSONObject open = HttpUtil.getUserInfo("B216836B97FD61B7301A93C306947A7F","854F4EE6931B17857BCD64B3CE22A88E");
        System.out.println(open.get("year"));
        Date d=new Date(DateUtil.stringToData((String)open.get("year"),"yy").getTime());
        System.out.println();

    }
}
