package xin.toheart.door.web.session;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;

/**
 * author   xieqx
 * desc     相关常用bean组件的初始化操作(Session操作类 MD5加密类，自定义的数据库类型等)
 * createTime  2018/7/17
 */
@Configuration
public class BeanInitConfigure {
    //初始化session操作的提供者
    @Bean(name="sessionProvider")
    public SessionProvider getSessionProvider() {
        return new HttpSessionProvider();
    }
}
