package com.dubm.apply.spring.springaop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

    @Pointcut(value = "execution(* *..springaop.*.*(..) )")
    public void pc() {
    }

    @Before(value = "MyAspect.pc()")
    public void log(){
        System.out.println("日志记录。。。。。。");
    }

//    @Around(value = "MyAspect.pc()")
//    public Object aroundLog(ProceedingJoinPoint joinPoint) {
//        try {
//            Object[] args = joinPoint.getArgs();
//            System.out.println("开启事务");
//            Object proceed = joinPoint.proceed(args);
//            int a = 1 / 0;
//            System.out.println("提交事务");
//        } catch (Throwable throwable) {
////            throwable.printStackTrace();
//            System.out.println("回滚事务");
//        } finally {
//            System.out.println("释放资源");
//        }
//        return null;
//    }



}

