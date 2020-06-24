package com.dubm.apply.spring.test;

import com.dubm.apply.spring.SpringConfig;
import com.dubm.apply.spring.ioc.JdbcConfig;
import com.dubm.apply.spring.po.Dept;
import com.dubm.apply.spring.po.User;
import com.dubm.apply.spring.service.TestServiceImpl;
import com.dubm.apply.spring.service.UserService;
import com.dubm.apply.spring.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class IoCTest {

//    @Autowired
//    User user;

//    @Autowired
//    @Qualifier("userServiceImpl1")
//    UserService userService;
//    @Autowired
//    @Qualifier("userServiceImpl1")
//    UserService userService;
    @Autowired
    UserService userServiceImpl1;
    @Resource
    JdbcConfig jdbcConfig;
    @Resource
    Dept dept;
    @Resource
    TestServiceImpl testService;


    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
    }

    @Test
    public void test1() {
        testService.sayHello();
        testService.sayWorld();
    }

    @Test
    public void byNameAutowiredFieldTest(){
        userServiceImpl1.listUser();
    }

}
