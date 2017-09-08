package com.tanner.dao.testdao;

import com.tanner.model.testmodel.User;
import org.apache.ibatis.annotations.Insert;

/**
 * create by linuxea on 2017/9/8 10:31
 **/
public interface UserMapper {

    @Insert("insert into user (id,name) values (#{id}, #{name})")
    void addUser(User user);
}
