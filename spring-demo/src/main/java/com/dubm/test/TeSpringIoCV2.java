package com.dubm.test;

import com.dubm.ioc.BeanDefinition;
import com.dubm.ioc.BeanReference;
import com.dubm.ioc.PropertyValue;
import com.dubm.ioc.TypeStringValue;
import com.dubm.po.User;
import com.dubm.service.UserService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 手写IoC V2版本
 */
public class TeSpringIoCV2 {

    // 存储IoC帮我们创建好的对象，key:<bean>标签id，value：被创建的对象
    private Map<String, Object> singletonObjects = new HashMap<>();

    // 存储xml配置文件解析出来的标签对象
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Test
    public void test() {
        UserService userService = (UserService) getBean("userService");
        Map<String,Object> param = new HashMap<>();
        param.put("id",5L);
        List<User> users = userService.listByMap(param, "queryUserById");
    }

    @Before
    public void before() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("beans.xml");
        try {
            Document document = new SAXReader().read(is);
            parseDefinitions(document.getRootElement());
        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }

    private void parseDefinitions(Element rootElement) {
        List<Element> elements = rootElement.elements();
        for (Element element : elements) {
            String name = element.getName();
            if ("bean".equals(name)) {
                parseDefaultElement(element);
            }
        }
    }

    private void parseDefaultElement(Element element) {
        String id = element.attributeValue("id");
        String name = element.attributeValue("name");
        String clazzPath = element.attributeValue("class");
        String initMethod = element.attributeValue("init-method");
        String scope = element.attributeValue("scope");
        scope = scope != null && !scope.equals("") ? scope : BeanDefinition.SCOPE_SINGLETON;

        BeanDefinition beanDefinition = new BeanDefinition(id, clazzPath, initMethod, scope);

        List<Element> propertyElements = element.elements();
        for (Element propertyElement : propertyElements) {
            parsePropertyElement(beanDefinition, propertyElement);
        }
        beanDefinitionMap.put(id, beanDefinition);

    }

    private void parsePropertyElement(BeanDefinition beanDefinition, Element propertyElement) {
        String name = propertyElement.attributeValue("name");
        String value = propertyElement.attributeValue("value");
        String ref = propertyElement.attributeValue("ref");
        PropertyValue pv = null;
        if (value != null && !"".equals(value)) {
            Class<?> targetType = getTypeByFieldName(beanDefinition.getClazzPath(), name);
            TypeStringValue typeStringValue = new TypeStringValue(value, targetType);
            pv = new PropertyValue(name, typeStringValue);
            beanDefinition.addPropertyValue(pv);
        } else if (ref != null && !ref.equals("")) {
            BeanReference beanReference = new BeanReference(ref);
            pv = new PropertyValue(name, beanReference);
            beanDefinition.addPropertyValue(pv);
        }
    }

    private Class<?> getTypeByFieldName(String beanClassName, String name) {
        try {
            Class<?> clazz = Class.forName(beanClassName);
            Field field = clazz.getDeclaredField(name);
            return field.getType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private Object getBean(String beanId) {

        // bean缓存中如果有就直接返回
        Object bean = singletonObjects.get(beanId);
        if (Objects.nonNull(bean)) {
            return bean;
        }

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanId);
        if (Objects.isNull(beanDefinition)) {
            return null;
        }

        if (beanDefinition.isSingleton()) {
            // 单例模式下，创建好的bean需要存入缓存中
            bean = doCreateBean(beanDefinition);
            singletonObjects.put(beanId, bean);
        } else if (beanDefinition.isPrototype()) {
            // 多例每次都会创建新的bean
            bean = doCreateBean(beanDefinition);
        }
        return bean;

    }

    private Object doCreateBean(BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            // 创建对象
            // 注入属性
            return populateBean(beanDefinition);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object populateBean(BeanDefinition beanDefinition) {
        Class<?> clazz = beanDefinition.getClazz();
        Object bean = null;
        try {
            bean = clazz.newInstance();
            List<PropertyValue> propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue p : propertyValues) {


                String fieldName = p.getName();
                Object fieldValue = p.getValue();
                Object value = resolveValueOrReference(fieldValue, p);
                try {
                    Field declaredField = clazz.getDeclaredField(fieldName);
                    declaredField.setAccessible(true);
                    declaredField.set(bean, value);
                    return bean;
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Object resolveValueOrReference(Object fieldValue, PropertyValue p) {
        if (fieldValue instanceof BeanReference) {
            BeanReference value = (BeanReference) fieldValue;
            return getBean(value.getRef());
        } else if (fieldValue instanceof TypeStringValue) {
            TypeStringValue value = (TypeStringValue) fieldValue;
            String v = value.getValue();
            Class<?> type = value.getTargetType();
            if (type == Integer.class) {
                return Integer.parseInt(v);
            } else if (type == String.class) {
                return v;
            }
        }

        return null;
    }


}
