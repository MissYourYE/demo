package com.dubm.apply.spring.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxyUtil<T> {

    private  T t;

    private CglibDynamicProxyUtil(T t) {
        this.t = t;
    }

    public static <T> CglibDynamicProxyUtil<T> create(T t){
        return new CglibDynamicProxyUtil<>(t);
    }

    public T getProxy(){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib 前置增强。。。");
                Object result = methodProxy.invokeSuper(o, objects);
                System.out.println("cglib 后置增强。。。");
                return null;
            }
        });
        Object proxy = enhancer.create();
        return (T)proxy;
    }

}
