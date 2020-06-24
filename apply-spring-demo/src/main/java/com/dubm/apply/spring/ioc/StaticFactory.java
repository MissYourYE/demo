package com.dubm.apply.spring.ioc;

import com.dubm.apply.spring.po.User;

public class StaticFactory {
    public static User createUser() {
        return new User();
    }
}
