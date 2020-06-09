package com.dubm;

import com.dubm.po.Dept;
import com.dubm.po.User;
import com.google.common.base.CaseFormat;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

public class MybatisV1 {

    private Properties jdbcProperties = new Properties();

    private int n = 3;

    @Test
    public void test() {
        List<User> users = selectByCondition("queryUserById", 5);
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 5);
        paramMap.put("acct", "%s%");
        List<User> result = selectByCondition("queryUserByIdAndAcct", paramMap);
        HashMap<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("id", 6);
        paramMap1.put("deptName", "%事业%");
        List<Dept> result1 = selectByCondition("queryDeptByIdAndName", paramMap1);
        users.forEach(u -> System.out.println(u.toString()));
        System.out.println("===================");
        result.forEach(r -> System.out.println(r.toString()));
        System.out.println("===================");
        result1.forEach(r -> System.out.println(r.toString()));
        System.out.println("===================");
    }

    private void loadProperties() {
        InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
            jdbcProperties.load(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Connection getConnection() {

        loadProperties();

        try {
            // 加载数据库驱动
            Class.forName(jdbcProperties.getProperty("jdbc.driver"));
            return DriverManager.getConnection(
                    jdbcProperties.getProperty("jdbc.url"),
                    jdbcProperties.getProperty("jdbc.username"),
                    jdbcProperties.getProperty("jdbc.password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private <T> List<T> selectByCondition(String statementId, Object param) {

        Connection connection = getConnection();
        String sql = jdbcProperties.getProperty("sql." + statementId);
        try {
            if (null != connection && null != sql) {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                if (ClassTypeUtils.isSimpleType(param.getClass())) {
                    preparedStatement.setObject(1, param);
                } else if (param instanceof Map) {
                    Map paramMap = (Map) param;
                    String paramNameStr = jdbcProperties.getProperty("sql." + statementId + ".paramnames");
                    String[] paramNameArray = paramNameStr.split(",");
                    for (int i = 0; i < paramNameArray.length; i++) {
                        Object o = paramMap.get(paramNameArray[i]);
                        preparedStatement.setObject(i + 1, o);
                    }
                }
                ResultSet resultSet = preparedStatement.executeQuery();
                String resultClassName = jdbcProperties.getProperty("sql." + statementId + ".resultclass");
                Class<?> clazz = Class.forName(resultClassName);
                Object object;
                ArrayList<T> users = new ArrayList<>();
                while (resultSet.next()) {
                    object = clazz.newInstance();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 0; i < columnCount; i++) {
                        String columnName = metaData.getColumnName(i + 1);
                        // 使用驼峰命名转换成Java字段格式
                        Field declaredField = clazz.getDeclaredField(
                                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName));
                        declaredField.setAccessible(true);
                        declaredField.set(object, resultSet.getObject(columnName));
                    }
                    users.add((T) object);
                }
                return users;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        User user1 = new User();
        user1.setAcct("dubm");
        Class<User> userClass = User.class;
        User user = userClass.newInstance();
        Field[] fields = userClass.getFields();
        Field[] declaredFields = userClass.getDeclaredFields();
        Field id = userClass.getDeclaredField("id");
        Field acct = userClass.getDeclaredField("acct");
        id.setAccessible(true);
        acct.setAccessible(true);
        id.set(user,100L);
        acct.set(user,acct.get(user1));
        System.out.println(user.getAcct());
        String typeName = userClass.getTypeName();


    }

}
