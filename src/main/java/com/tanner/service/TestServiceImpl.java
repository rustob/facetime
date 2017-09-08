package com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * create by linuxea on 2017/9/8 10:31
 **/

@Transactional(propagation = Propagation.NESTED)
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        userMapper.addUser(user);
    }

}
