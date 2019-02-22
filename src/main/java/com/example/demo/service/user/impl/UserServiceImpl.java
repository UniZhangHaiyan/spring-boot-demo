package com.example.demo.service.user.impl;

import com.example.demo.dao.user.IUserMapper;
import com.example.demo.entity.user.UserEntity;
import com.example.demo.service.user.IUserService;
import com.example.demo.util.lock.jedis.Lock;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserMapper userMapper;

    @Autowired
    private Lock lock;

    @Override
    public List<UserEntity> findUserList() {
        try {
            lock.lock("zhy", 5L, 10 * 60 * 1000L);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        PageInfo<UserEntity> userEntityPageInfo = null;
        try {
            userEntityPageInfo = PageHelper.startPage(1, 10).doSelectPageInfo(() -> userMapper.selectUserList());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock("zhy");
        }
        return userEntityPageInfo == null ? null : userEntityPageInfo.getList();
    }
}
