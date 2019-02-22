package com.example.demo.util.datasource;

/**
 * DataSourceHolder
 *
 * @author zhanghaiyan 2019/2/20
 * @description 数据源持有类
 * @modifier
 */
public class DataSourceHolder {
    private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    public static void setDataSource(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    public static String getDataSourceKey() {
        return dataSourceKey.get();
    }

    public static void clear() {
        dataSourceKey.remove();
    }
}
