package com.dubm.apply.spring;

import com.dubm.apply.spring.service.UserServiceImpl;
import org.springframework.context.annotation.*;

/**
 * @author dubaoming
 */
@Configuration
@ComponentScan(basePackages = "com.dubm.apply.spring.springaop")
@EnableAspectJAutoProxy
//@Import(SpringConfig1.class)
public class SpringConfig {

    // spring容器初始化时，会调用配置类的无参构造方法
    public SpringConfig() {
        System.out.println("纯注解式Spring容器启动。。。。。");
    }
}
