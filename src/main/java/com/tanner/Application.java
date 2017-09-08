package com.tanner;

import com.tanner.model.testmodel.User;
import com.tanner.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * create by linuxea on 2017/9/8 10:44
 **/
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // inject the actual template

    public void jedis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService userService = (TestService) context.getBean("redisService");
        TestService testService = (TestService) context.getBean("redisService");
        testService.addUser(new User(98, "jedis test"));
    }

    @Resource(name = "redisTemplate")
    private ListOperations<String, String> listOps;

    public static void main(String[] args) {
        Application application = new Application();
//        application.hello();
//        application.jedis();
        application.addLink();
    }

    public void hello() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService userService = (TestService) context.getBean("testServiceImpl");
        User user = new User(908, "linuxea");
        logger.info(user.toString());
        userService.addUser(user);
    }

    // inject the template as ListOperations
    // can also inject as Value, Set, ZSet, and HashOperations
    public void addLink() {
        RedisTemplate<String, String> template
                = context.getBean("redisTemplate", RedisTemplate.class);
        boolean result =
                template.execute(new RedisCallback<Boolean>() {
                    @Override
                    public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                        return connection.setNX("fff".getBytes(), "dd".getBytes());
                    }
                });

        System.out.println(result);

    }

}
