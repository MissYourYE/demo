package com.dubm.service;

import com.dubm.po.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> listByMap(Map<String,Object> param,String statementId);
}
