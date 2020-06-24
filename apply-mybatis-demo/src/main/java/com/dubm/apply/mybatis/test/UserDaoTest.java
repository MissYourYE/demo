package com.dubm.apply.mybatis.test;

import com.dubm.apply.mybatis.dao.basic.UserDao;
import com.dubm.apply.mybatis.dao.basic.impl.UserDaoImpl;
import com.dubm.apply.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("basic/SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }

    @Test
    public void test(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.selectById(1L);
        List<User> users = userDao.selectByAcct("demo");
        System.out.println(user.toString());
        System.out.println(users.toString());
    }

    @Test
    public void testInsert(){
        UserDao userDao = new UserDaoImpl(sqlSessionFactory);
        User user = new User();
        user.setId(null);
        user.setAcct("demo");
        int count = userDao.insert(user);
        System.out.println(count);
        System.out.println(user.getId());
    }
}
