package com.example.demo.util.datasource;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * DataSourceAspect
 *
 * @author zhanghaiyan 2019/2/20
 * @description
 * @modifier
 */
@Aspect
@Component
public class DataSourceAspect {

    private static final String METHOD_FIND = "find";

    private static final String METHOD_GET = "get";

    private String dataSource;

    /**
     * 切入点
     */
    @Pointcut("execution(* com.example.demo.service..*.*(..))")
    public void webDataSource() {
    }

    /**
     * 在执行切面方法前需要执行的方法
     *
     * @param joinPoint
     */
    @Before("webDataSource()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        Class<?>[] interfaces = joinPoint.getTarget().getClass().getInterfaces();
        for (Class<?> inter : interfaces) {
            System.out.println(inter);
            //判断接口上是否有DataSourceType注解
            if (inter.isAnnotationPresent(DataSourceType.class)) {
                //获取注解的value
                DataSourceType dataSourceType = inter.getAnnotation(DataSourceType.class);
                dataSource = dataSourceType.value();
                break;
            }
        }

        System.out.println(joinPoint.getSignature().getName());
        //检查方法名的前缀
        if (StringUtils.startsWithAny(joinPoint.getSignature().getName(), METHOD_FIND, METHOD_GET)) {
            //读取的方法使用从数据库
            DataSourceHolder.setDataSource(StringUtils.join(dataSource, "-slave"));
        } else {
            //写的方法使用主数据库
            DataSourceHolder.setDataSource(StringUtils.join(dataSource, "-master"));
        }
    }

    /**
     * 切点方法之后执行
     */
    @After("webDataSource()")
    public void doAfter() {
        System.out.println("清除数据源");
        DataSourceHolder.clear();
    }
}
