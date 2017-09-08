package com.tanner;

import com.tanner.model.testmodel.User;
import com.tanner.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * create by linuxea on 2017/9/8 10:44
 **/
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        Application application = new Application();
        application.hello();
//        application.jedis();
    }


    public void hello() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService userService = (TestService) context.getBean("testServiceImpl");
        User user = new User(601, "linuxea");
        logger.info(user.toString());
        userService.addUser(user);
    }


    public void jedis() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService userService = (TestService) context.getBean("redisService");
        TestService testService = (TestService) context.getBean("redisService");
        testService.addUser(new User(98, "jedis test"));
    }

}
