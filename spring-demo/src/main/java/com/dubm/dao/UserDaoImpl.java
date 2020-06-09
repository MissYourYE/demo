package com.dubm.dao;

import com.dubm.po.User;
import com.dubm.util.ClassTypeUtils;
import com.google.common.base.CaseFormat;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    private DataSource dataSource;
    private Properties jdbcProperties = new Properties();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<User> selectList(Map<String, Object> param, String statementId) {
        loadProperties();
        String sql = jdbcProperties.getProperty("sql." + statementId);
        try {
            Connection connection = dataSource.getConnection();
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
                ArrayList<User> users = new ArrayList<>();
                while (resultSet.next()) {
                    User user = new User();
                    ResultSetMetaData metaData = resultSet.getMetaData();
                    int columnCount = metaData.getColumnCount();
                    for (int i = 0; i < columnCount; i++) {
                        String columnName = metaData.getColumnName(i + 1);
                        // 使用驼峰命名转换成Java字段格式
                        Field declaredField = clazz.getDeclaredField(
                                CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, columnName));
                        declaredField.setAccessible(true);
                        declaredField.set(user, resultSet.getObject(columnName));
                    }
                    users.add(user);
                }
                return users;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
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
}
