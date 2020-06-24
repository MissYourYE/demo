package com.dubm.apply.spring.springaop;

import org.springframework.stereotype.Component;

@Component
public class Target {
    public void sayHello(){
        System.out.println("hello ~~~");
    }

    public void sayWorld(){
        System.out.println("world ~~~");
    }
}
