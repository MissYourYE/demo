package com.dubm.apply.spring.service;

import com.dubm.apply.spring.po.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class UserServiceImpl1 implements UserService{
    @Override
    public List<User> listUser() {
        return null;
    }
}
