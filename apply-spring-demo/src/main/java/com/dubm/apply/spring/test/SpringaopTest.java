package com.dubm.apply.spring.test;

import com.dubm.apply.spring.springaop.Target;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-springaop.xml")
public class SpringaopTest {

    @Autowired
    Target target;

    @Test
    public void test(){
        target.sayHello();
        target.sayWorld();
    }


}
