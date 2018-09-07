package xin.toheart.door.common.util;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.Date;
import java.util.UUID;
@Configuration
public class FtpUplodUtil {
    private static final FTPClient client = new FTPClient();
    private static String hostFtp = null;

    //初始化
    public static void init(String host, int port, String username, String password) throws IOException {
        hostFtp = host;
        //连接
        client.connect(host, port);
        //登录
        client.login(username, password);
    }

    public static String upload(String path, String fileName, InputStream local) throws IOException {
        String datePath = DateUtil.dataToString(new Date(), "/yyyy/MM/dd");
        String realPath = path+datePath;
        //指定上传路径
        boolean exists = client.changeWorkingDirectory(realPath);
        if(!exists){
            String realPathArray[] = realPath.split("/");
            String base ="/";
            for(String rp:realPathArray){
                if(rp!=null && rp.length()>0){
                    base +=(rp+"/");
                    //创建目录（只能创建一级目录）
                    client.makeDirectory(base);
                }
            }
            //重新指定上传目录
            client.changeWorkingDirectory(realPath);
        }
        //文件后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //文件名
        String fileNameReal = UUID.randomUUID()+suffix;
        //指定上传方式
        client.setFileType(FTP.BINARY_FILE_TYPE);
        //上传文件
        client.storeFile(fileNameReal,local);
        System.out.println("1");
        //退出
        client.logout();
        System.out.println("2");
        //断开连接
        client.disconnect();
        System.out.println("3");
        return "http://39.106.169.130:2121"+datePath+"/"+fileNameReal;

    }
    public static void main(String[] args) throws SocketException, IOException {
        InputStream local = new FileInputStream(new File("D:\\Pictures\\dyh.jpg"));
        //初始化
        init("39.106.169.130", 21, "ftpuser", "ftpuser");
        //上传
        String res = upload("/home/ftpuser","dyh.jpg", local);
        System.out.println(res);
    }


}
