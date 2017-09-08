package com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String, String> template;

    public void addUser(User user) {
        User user1 = new User(1, "linuxea");
        User user2 = new User(2, "tony");
        userMapper.addUser(user1);
        int i = 10 / 0;
        userMapper.addUser(user2);
    }

}
