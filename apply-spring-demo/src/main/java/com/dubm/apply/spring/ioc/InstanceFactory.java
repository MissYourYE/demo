package com.dubm.apply.spring.ioc;

import com.dubm.apply.spring.po.User;

public class InstanceFactory {
    public User createUser(){
        return new User();
    }
}
