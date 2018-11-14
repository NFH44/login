package com.test.user.dao;

import com.test.user.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);

    User findByUsername(String username);
    int insert1(User user);
}
