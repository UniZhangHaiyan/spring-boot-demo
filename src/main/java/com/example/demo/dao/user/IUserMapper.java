package com.example.demo.dao.user;

import com.example.demo.entity.user.UserEntity;

import java.util.List;

/**
 * IUserMapper
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
public interface IUserMapper {
    List<UserEntity> selectUserList();
}
