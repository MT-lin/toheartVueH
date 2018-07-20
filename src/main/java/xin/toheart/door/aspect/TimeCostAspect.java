package xin.toheart.door.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


/**
 * 使用切面类来查看controller接口的执行时间
 */
@Aspect
//@Order(4)
@Component
public class TimeCostAspect {
    private static final Logger logger = LoggerFactory.getLogger(TimeCostAspect.class);

    @Pointcut("execution(* xin.toheart.door.controller.*.*(..))")
        public void timecost() {
    }


    @Around("timecost()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object o;
        try {
            o = pjp.proceed(pjp.getArgs());
        } catch (Throwable var7) {
            String message = var7.getClass().getName() + " / " + var7.getMessage() + " / " + var7.getStackTrace()[0];
            logger.error("error", message);
            throw var7;
        }

        //获取当前执行方法名称
        Signature s = pjp.getSignature();
        MethodSignature ms = (MethodSignature)s;
        String methodName = ms.getMethod().getName();



//        Signature sig = pjp.getSignature();
//        MethodSignature msig = null;
//        if (!(sig instanceof MethodSignature)) {
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        msig = (MethodSignature) sig;
//        Object target = pjp.getTarget();
//        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

        logger.info("[time cost] " + (System.currentTimeMillis() - startTime) + " ms [path is " + pjp.getTarget().getClass().getName() +"."+methodName+ "]");
        //logger.info("[time cost] " + (System.currentTimeMillis() - startTime) + " ms [path is " +ms.toString()+ "]");

        return o;
    }


    //后期 切入点 可以为指定的注解（比如时间花费注解，日志注解等）
    @Pointcut("@annotation(xin.toheart.door.annonation.TimeCostAnnotation)")
    public void timecostAnonation() {
    }


    @Around("timecostAnonation()")
    public Object aroundAnnotation(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object o;
        try {
            o = pjp.proceed(pjp.getArgs());
        } catch (Throwable var7) {
            String message = var7.getClass().getName() + " / " + var7.getMessage() + " / " + var7.getStackTrace()[0];
            logger.error("error", message);
            throw var7;
        }

        //获取当前执行方法名称
        Signature s = pjp.getSignature();
        MethodSignature ms = (MethodSignature)s;
        String methodName = ms.getMethod().getName();



//        Signature sig = pjp.getSignature();
//        MethodSignature msig = null;
//        if (!(sig instanceof MethodSignature)) {
//            throw new IllegalArgumentException("该注解只能用于方法");
//        }
//        msig = (MethodSignature) sig;
//        Object target = pjp.getTarget();
//        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());

        logger.info("[time cost] " + (System.currentTimeMillis() - startTime) + " ms [path is " + pjp.getTarget().getClass().getName() +"."+methodName+ "]");
        //logger.info("[time cost] " + (System.currentTimeMillis() - startTime) + " ms [path is " +ms.toString()+ "]");

        return o;
    }



}
