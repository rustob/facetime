package com.tanner;

import com.tanner.model.testmodel.User;
import com.tanner.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * create by linuxea on 2017/9/8 10:44
 **/
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    // inject the actual template
    @Autowired
    private RedisTemplate<String, String> template;


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
        application.addLink("name", "linuxea");
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
    public void addLink(String userId, String value) {
        template = (RedisTemplate<String, String>) context.getBean("redisTemplate");
        listOps.leftPush(userId, value);
        // or use template directly
        template.boundListOps(userId).leftPush(value);
    }

}
