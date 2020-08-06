package com.dubm.apply.mybatis.dao.xmproxy;

import com.dubm.apply.mybatis.po.Hello;

public interface HelloMapper {
    int insert(Hello record);

    int insertSelective(Hello record);

    Hello selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hello record);

    int updateByPrimaryKey(Hello record);
}