package com.dubm.apply.mybatis.dao.basic;

import com.dubm.apply.mybatis.po.User;

import java.util.List;

public interface UserDao {
    User selectById(Long id);
    List<User> selectByAcct(String acct);
    int insert(User user);
}
