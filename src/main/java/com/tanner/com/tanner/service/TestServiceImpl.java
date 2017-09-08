package com.tanner.com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;

/**
 * create by linuxea on 2017/9/8 10:31
 **/
public class TestServiceImpl implements TestService {


    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.addUser(user);
    }


    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
