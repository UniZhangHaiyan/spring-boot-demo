package com.example.demo.service.user;

import com.example.demo.entity.user.UserEntity;
import com.example.demo.util.datasource.DataSourceType;

import java.util.List;

/**
 * IUserService
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@DataSourceType("user")
public interface IUserService {
    List<UserEntity> findUserList();
}
