package com.dubm.apply.mybatis.dao.xmproxy;

import com.dubm.apply.mybatis.po.CustomerOrder;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CustomerOrderMapper {

    @Select("select * from customer_order where create_id = #{createId}")
    List<CustomerOrder> selectByCreateId(Long createId);
}
