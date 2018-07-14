package xin.toheart.door;

public class Test {
    @org.junit.Test
    public void subStringd(){
//        String s="access_token=854F4EE6931B17857BCD64B3CE22A88E&expires_in=7776000&refresh_token";
//        String y=s.substring(s.indexOf("=")+1,s.indexOf("&"));
        String result="callback( {\"client_id\":\"101484099\",\"openid\":\"B216836B97FD61B7301A93C306947A7F\"}";
        String openId=result.substring(result.indexOf("openid")+9,result.lastIndexOf("\""));
        System.out.println(openId);
    }
}
