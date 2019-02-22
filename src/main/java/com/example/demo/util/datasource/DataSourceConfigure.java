package com.example.demo.util.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * DataSourceConfigure
 *
 * @author zhanghaiyan 2019/2/20
 * @description 数据源配置类
 * @modifier
 */
@Configuration
public class DataSourceConfigure {

    /**
     * 从配置文件获取数据源信息为每个数据源创建一个DataSource的实例
     * 对应xml的配置
     * <bean id="user-master" parent="dataSourceBase" init-method="init" destroy-method="close">
     * <property name="url" value="#{jdbcProps['user.master.url']}"/>
     * <property name="username" value="#{jdbcProps['user.master.username']}"/>
     * <property name="password" value="#{jdbcProps['user.master.password']}"/>
     * </bean>
     * <bean id="user-slave1" parent="dataSourceBase" init-method="init" destroy-method="close">
     * <property name="url" value="#{jdbcProps['user.slave1.url']}"/>
     * <property name="username" value="#{jdbcProps['user.slave1.username']}"/>
     * <property name="password" value="#{jdbcProps['user.slave1.password']}"/>
     * </bean>
     *
     * @return
     */
    @Bean("user-master")
    @ConfigurationProperties(prefix = "db.user-master")
    public DataSource userMaster() {
        System.out.println("创建数据源-==> userMaster");
        return DataSourceBuilder.create().build();
    }

    @Bean("user-slave")
    @ConfigurationProperties(prefix = "db.user-slave")
    public DataSource userSlave() {
        System.out.println("创建数据源-==> userSlave");
        return DataSourceBuilder.create().build();
    }

    /**
     * @Primary 这个注解用于指明主数据源，用了这个之后无法路由到其他数据源，不知道为啥
     */
    @Bean("buyloan-master")
    @ConfigurationProperties(prefix = "db.buyloan-master")
    public DataSource buyloanMaster() {
        System.out.println("创建数据源-==> buyloanMaster");
        return DataSourceBuilder.create().build();
    }

    @Bean("buyloan-slave")
    @ConfigurationProperties(prefix = "db.buyloan-slave")
    public DataSource buyloanSlave() {
        System.out.println("创建数据源-==> buyloanSlave");
        return DataSourceBuilder.create().build();
    }

    /**
     * 注册数据源路由类
     * 对应xml配置
     * <bean id="dataSource" class="com.yoho8.framework.datasource.RoutingDataSource">
     * <property name="targetDataSources">
     * <map key-type="java.lang.String">
     * <entry value-ref="buyloan-master" key="buyloan-master"/>
     * <entry value-ref="buyloan-slave1" key="buyloan-slave1"/>
     * <entry value-ref="user-master" key="user-master"/>
     * <entry value-ref="user-slave1" key="user-slave1"/>
     * </map>
     * </property>
     * <property name="defaultTargetDataSource" ref="buyloan-master"/>
     * </bean>
     *
     * @return
     */
    @Bean
    public DataSource dynamicDataSource() {
        Map<Object, Object> dataSourceMap = new HashMap<>();
        dataSourceMap.put("user-slave", userSlave());
        dataSourceMap.put("user-master", userMaster());
        dataSourceMap.put("buyloan-slave", buyloanSlave());
        dataSourceMap.put("buyloan-master", buyloanMaster());
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        //设置多数据源
        dynamicDataSource.setTargetDataSources(dataSourceMap);
        //设置默认数据源
        dynamicDataSource.setDefaultTargetDataSource(buyloanMaster());
        return dynamicDataSource;
    }

    /**
     * 注册sqlSessionFactory类
     * 对应xml配置
     * <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
     * <property name="dataSource" ref="dataSource"/>
     * <property name="configLocation" value="classpath:mybatis-config.xml"/>
     * <property name="mapperLocations" value="classpath:mapper/..."/>
     * </bean>
     *
     * @param dynamicDataSource @Qualifier 指定， 测试一下不用这个可不可以
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dynamicDataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dynamicDataSource);
        sqlSessionFactoryBean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml"));
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/**/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    /**
     * 注册事务管理类
     * 对应xml配置
     * <bean id="txManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
     * <property name="dataSource" ref="dataSource"/>
     * </bean>
     *
     * @param dynamicDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dynamicDataSource) {
        return new DataSourceTransactionManager(dynamicDataSource);
    }
}
