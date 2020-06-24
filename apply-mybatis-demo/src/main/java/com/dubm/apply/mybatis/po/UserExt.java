package com.dubm.apply.mybatis.po;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString(callSuper = true)
public class UserExt extends User {
    private Dept dept;
    private List<CustomerOrder> orders;
}
