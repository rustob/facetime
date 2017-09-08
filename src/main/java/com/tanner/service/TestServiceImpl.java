package com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


/**
 * create by linuxea on 2017/9/8 10:31
 **/

@Transactional(propagation = Propagation.NESTED)
@Service
public class TestServiceImpl extends RedisGeneratorDao<String, String> implements TestService {

    @Autowired
    private UserMapper userMapper;

    public void addUser(User user) {
        boolean result =
                super.redisTemplate.execute(new RedisCallback<Boolean>() {
                    @Override
                    public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                        return connection.setNX("abc".getBytes(), "cde".getBytes());
                    }
                });
        System.out.println(result);
        userMapper.addUser(user);
    }

}
