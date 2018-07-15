package xin.toheart.door.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import xin.toheart.door.common.constant.CommonsConstant;
import xin.toheart.door.pojo.User;
import xin.toheart.door.web.session.HttpSessionProvider;
import xin.toheart.door.web.session.SessionProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * author   xieqx
 * createTime  2018/7/15
 * 用户登录的拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor{

     //session 的相关工具类
     @Autowired
     private SessionProvider sessionProvider;
    /**
     * 进入controller之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //System.out.println("执行preHandle方法....");
        //登录页面 不进行拦截 （登录页面有qq 微信 和自己的登录url）
        //获取当前请求的url
        String url = request.getRequestURL().toString();
        System.out.println("请求的url: "+url);
        //后期使用数组，集合包含多个登录请求
        if(!url.contains("/")&&!url.contains("/login")){
           // User user = (User) sessionProvider.getAttribute(request, CommonsConstant.UserConstant.CURRENT_BUYER);
           User user = (User) request.getSession().getAttribute(CommonsConstant.UserConstant.CURRENT_BUYER);
            if(user==null){
                response.sendRedirect("/login"); //重定向到登录
                return false;
            }

        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("执行postHandle方法....");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("执行afterCompletion方法....");
    }
}
