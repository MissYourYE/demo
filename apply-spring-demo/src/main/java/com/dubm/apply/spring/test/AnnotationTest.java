package com.dubm.apply.spring.test;

import com.dubm.apply.spring.SpringConfig;
import com.dubm.apply.spring.po.Dept;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationTest {

    @Test
    public void test() {
        // 原来xml方式上下文容器：
        // ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        Dept dept = (Dept) ctx.getBean("dept");
        System.out.println(dept);
    }


}
