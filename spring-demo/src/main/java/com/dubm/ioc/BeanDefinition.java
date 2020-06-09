package com.dubm.ioc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dubaoming
 */
public class BeanDefinition {

    // <bean>标签的id、name属性值，两者是2选1使用
    private String beanName;
    // <bean>标签class属性（类全限定名）
    private String clazzPath;
    // 通过clazzPath反射得到的对象
    private Class<?> clazz;
    // 初始化方法名
    private String initMethod;
    // 单例or多例开关配置，默认单例
    private String scope;

    // <bean>标签中property键值对儿
    List<PropertyValue> propertyValues = new ArrayList<>();

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";

    public BeanDefinition(String beanName, String clazzPath, String initMethod, String scope) {
        this.beanName = beanName;
        this.clazzPath = clazzPath;
        this.initMethod = initMethod;
        this.scope = scope;
    }

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getClazzPath() {
        return clazzPath;
    }

    public void setClazzPath(String clazzPath) {
        this.clazzPath = clazzPath;
    }

    public Class<?> getClazz() {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(clazzPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return aClass;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getInitMethod() {
        return initMethod;
    }

    public void setInitMethod(String initMethod) {
        this.initMethod = initMethod;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public List<PropertyValue> getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }

    public boolean isSingleton() {
        return SCOPE_SINGLETON.equals(this.scope);
    }

    public boolean isPrototype() {
        return SCOPE_PROTOTYPE.equals(this.scope);
    }
}
