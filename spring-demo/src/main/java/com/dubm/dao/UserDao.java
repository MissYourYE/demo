package com.dubm.dao;

import com.dubm.po.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> selectList(Map<String,Object> param,String statementId);
}
