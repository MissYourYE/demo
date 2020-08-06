package com.dubm.apply.mybatis.dao.xmproxy;

import com.dubm.apply.mybatis.po.User;

import java.util.List;

public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void batchInsert(List<User> users);
}