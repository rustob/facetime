package com.tanner.com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * create by linuxea on 2017/9/8 10:31
 **/
@Service("fuckService")
public class TestServiceImpl implements TestService {

    @Autowired
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
