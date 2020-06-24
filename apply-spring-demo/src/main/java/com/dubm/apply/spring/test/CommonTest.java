package com.dubm.apply.spring.test;

import com.dubm.apply.spring.po.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonTest {

    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
//        User instanceUser = (User) ctx.getBean("instanceUser");
//        System.out.println(instanceUser);
//        User staticUser = (User) ctx.getBean("staticUser");
//        System.out.println(staticUser);
    }

}
