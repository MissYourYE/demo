package com.dubm.apply.spring.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicProxyUtil<T> {

    private final T t;

    private JDKDynamicProxyUtil(T t) {
        this.t = t;
    }

    public static <T> JDKDynamicProxyUtil<T> create(T t) {
        return new JDKDynamicProxyUtil<>(t);
    }

    public T getProxy() {
        Object p = Proxy.newProxyInstance(
                t.getClass().getClassLoader(),
                t.getClass().getInterfaces(),
                (Object proxy, Method method, Object[] args) -> {
                    System.out.println("增强功能开始。。。");
                    Object invoke = method.invoke(t, args);
                    System.out.println("增强功能结束。。。");
                    return invoke;
                }
        );
        return (T) p;
    }



}
