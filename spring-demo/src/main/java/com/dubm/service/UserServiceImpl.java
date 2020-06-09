package com.dubm.service;

import com.dubm.dao.UserDao;
import com.dubm.po.User;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> listByMap(Map<String, Object> param, String statementId) {
        return userDao.selectList(param, statementId);
    }
}
