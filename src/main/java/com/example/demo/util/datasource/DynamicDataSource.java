package com.example.demo.util.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.lang.Nullable;

/**
 * DynamicDataSource
 *
 * @author zhanghaiyan 2019/2/20
 * @description 数据源动态路由类
 * @modifier
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     * 返回当前数据源
     *
     * @return
     */
    @Nullable
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSourceKey();
    }
}
