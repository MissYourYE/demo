package com.dubm.apply.spring.test;

import com.dubm.apply.spring.proxy.CglibDynamicProxyUtil;
import com.dubm.apply.spring.proxy.JDKDynamicProxyUtil;
import com.dubm.apply.spring.service.TestService;
import com.dubm.apply.spring.service.TestServiceImpl;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    @Test
    public void jdkDynamicProxyTest() {
//        TestService ts = new TestServiceImpl();
//        JDKDynamicProxyUtil<TestService> util = JDKDynamicProxyUtil.create(ts);
//        ts = util.getProxy();
//        ts.sayHello();
    }

    @Test
    public void test() {
        // 必须是final
//        final TestService ts = new TestServiceImpl();
//        Object proxy = Proxy.newProxyInstance(
//                // param1:类加载器
//                ts.getClass().getClassLoader(),
//                // param2:接口数组
//                ts.getClass().getInterfaces(),
//                // param3：InvocationHandler对象
//                new InvocationHandler() {
//                    @Override
//                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("前置增强。。。。。。");
//                        Object result = method.invoke(ts, args);
//                        System.out.println("后置增强。。。。。。");
//                        return null;
//                    }
//                });
//        // 只能用接口强转
//        TestService proxyTestService = (TestService) proxy;
//        proxyTestService.sayHello();
    }

    @Test
    public void test1(){
        TestServiceImpl testServiceImpl = new TestServiceImpl();
        CglibDynamicProxyUtil<TestServiceImpl> util = CglibDynamicProxyUtil.create(testServiceImpl);
        TestServiceImpl proxy = util.getProxy();
        proxy.sayWorld();
    }

    @Test
    public void testCglib(){
        TestServiceImpl testServiceImpl = new TestServiceImpl();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(testServiceImpl.getClass());
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
        TestServiceImpl proxyTestServiceImpl = (TestServiceImpl) proxy;
        proxyTestServiceImpl.sayWorld();
    }
}
