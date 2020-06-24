package com.dubm.apply.mybatis.test;

import com.dubm.apply.mybatis.dao.xmproxy.CustomerOrderMapper;
import com.dubm.apply.mybatis.dao.xmproxy.UserMapper;
import com.dubm.apply.mybatis.po.CustomerOrder;
import com.dubm.apply.mybatis.po.User;
import com.dubm.apply.mybatis.po.UserExt;
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
        User user = userMapper.selectById(1L);
//        UserExt user = userMapper.selectWithDept(6L);
//        UserExt userExt = userMapper.selectWithDeptToMap(6L);
//        UserExt userExt = userMapper.selectWithOrders(122L);
        System.out.println(user);
    }

    @Test
    public void customerOrderTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CustomerOrderMapper mapper = sqlSession.getMapper(CustomerOrderMapper.class);
        List<CustomerOrder> customerOrders = mapper.selectByCreateId(122L);
    }

    @Test
    public void lazyTest() throws InterruptedException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserExt user = mapper.selectByLazyLoad(122L);
//        Thread.sleep(5000);
        user.getId();

    }

    @Test
    public void cacheTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectById(1L);
        User user1 = mapper.selectById(1L);
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
        User user1 = mapper1.selectById(1L);
        sqlSession1.close();
        User user2 = mapper2.selectById(1L);
        sqlSession2.close();
        mapper3.updateNameById(156L,"test_ae001");
        sqlSession3.close();
        User user = mapper4.selectById(1L);
        sqlSession4.close();
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int count =mapper.updateNameById(156L,"be");
        sqlSession.close();
        System.out.println(count);
    }


}
