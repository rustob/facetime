package com.tanner;

import com.tanner.com.tanner.service.TestService;
import com.tanner.model.testmodel.User;
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
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        TestService userService = (TestService) context.getBean("fuckService");
        User user = new User(23, "linuxea");
        logger.info(user.toString());
        userService.addUser(user);
    }

}
