package com.example.demo.util.datasource;

import java.lang.annotation.*;

/**
 * DataSourceType
 *
 * @author zhanghaiyan 2019/2/20
 * @description 数据源枚举类
 * @modifier
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceType {
    String value() default "buyloan";

    String buyloan = "buyloan";
    String user = "user";
}
