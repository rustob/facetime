package com.tanner.com.tanner.service;

import com.tanner.model.testmodel.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * create by linuxea on 2017/9/8 10:30
 **/
@Transactional(propagation = Propagation.REQUIRED)
public interface TestService {

    void addUser(User user);

}
