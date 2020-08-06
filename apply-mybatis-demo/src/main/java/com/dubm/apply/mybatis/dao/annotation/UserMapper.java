package com.dubm.apply.mybatis.dao.annotation;

import com.dubm.apply.mybatis.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User selectById(Long id);

    @Select("select * from user where acct like '%${value}%'")
    List<User> selectByAcct(String acct);
}
