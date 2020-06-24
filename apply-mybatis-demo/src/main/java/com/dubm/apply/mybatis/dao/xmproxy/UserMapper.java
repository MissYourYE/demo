package com.dubm.apply.mybatis.dao.xmproxy;

import com.dubm.apply.mybatis.po.User;
import com.dubm.apply.mybatis.po.UserExt;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.io.Flushable;

public interface UserMapper {

    User selectById(Long id);

    UserExt selectWithDept(Long id);

    UserExt selectWithDeptToMap(Long id);

    UserExt selectWithOrders(Long id);

    UserExt selectByLazyLoad(Long id);

//    @Update("update user set real_name = #{name} where id = #{id}")
    int updateNameById(@Param("id") Long id,@Param("name") String name);
}
