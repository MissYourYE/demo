package com.dubm.apply.mybatis.test;

import com.dubm.apply.mybatis.dao.xmproxy.UserMapper;
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

public class XMLProxyUserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("xmlproxy/SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        is.close();
    }

    @Test
    public void test(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByPrimaryKey(1);
//        UserExt user = userMapper.selectWithDept(6L);
//        UserExt userExt = userMapper.selectWithDeptToMap(6L);
//        UserExt userExt = userMapper.selectWithOrders(122L);
        System.out.println(user);
    }

    @Test
    public void lazyTest() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void cacheTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        User user1 = mapper.selectByPrimaryKey(1);
    }

    @Test
    public void twoLevelCacheTest(){
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
        SqlSession sqlSession4 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
        UserMapper mapper4 = sqlSession4.getMapper(UserMapper.class);
    }

    @Test
    public void updateTest(){

    }


}
