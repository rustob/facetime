package com.tanner.service;

import com.tanner.dao.testdao.UserMapper;
import com.tanner.model.testmodel.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
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
        User user1 = new User(99, "linuxea");
        User user2 = new User(999, "tony");
        userMapper.addUser(user1);
        userMapper.addUser(user2);

        boolean result =
                template.execute(new RedisCallback<Boolean>() {
                    @Override
                    public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                        return connection.setNX("name".getBytes(), "linuxea".getBytes());
                    }
                });

        System.out.println("###################################");
        System.out.println(result);
    }

}
