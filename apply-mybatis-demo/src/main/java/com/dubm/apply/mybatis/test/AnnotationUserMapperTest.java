package com.dubm.apply.mybatis.test;

import com.dubm.apply.mybatis.dao.annotation.UserMapper;
import com.dubm.apply.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AnnotationUserMapperTest {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("annotation/SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1L);
        List<User> users = mapper.selectByAcct("demo");
        System.out.println(user);
        System.out.println(users.toString());
    }
}
