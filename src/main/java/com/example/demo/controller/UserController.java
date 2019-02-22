package com.example.demo.controller;

import com.example.demo.entity.user.UserEntity;
import com.example.demo.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * UserController
 *
 * @author zhanghaiyan 2019/2/21
 * @description
 * @modifier
 */
@RestController
@RequestMapping("userInfo")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public String getUserList() {
        List<UserEntity> userEntityList = userService.findUserList();
        if (CollectionUtils.isEmpty(userEntityList)) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        userEntityList.forEach(userEntity -> result.append(userEntity.getUserCode()).append("\n"));
        return result.toString();
    }
}
