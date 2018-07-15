package xin.toheart.door.webConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import xin.toheart.door.interceptor.LoginInterceptor;

/**
 * author   xieqx
 * createTime  2018/7/15
 */
@Configuration
public class LoginConfig extends WebMvcConfigurationSupport {

    /**
     * 注册 拦截器

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
       // super.addInterceptors(registry);
    }
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截所有请求
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}