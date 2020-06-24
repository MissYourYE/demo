package com.dubm.apply.spring;

import com.dubm.apply.spring.po.Dept;
import org.springframework.context.annotation.Bean;

public class SpringConfig1 {
//    @Bean
    public Dept dept() {
        return new Dept();
    }
}
