package com.dubm.apply.mybatis.dao.basic.impl;

import com.dubm.apply.mybatis.dao.basic.UserDao;
import com.dubm.apply.mybatis.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private final SqlSessionFactory sqlSessionFactory;

    /**
     * 注入SqlSessionFactory
     */
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User selectById(Long id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        /**
         * 通过sqlsession调用selectOne方法获取一条结果集
         * 参数1：指定定义的statement的id
         * 参数2：指定向statement中传递的参数
         */

        User user = sqlSession.selectOne("test.selectById", id);
        sqlSession.close();
        return user;
    }

    @Override
    public List<User> selectByAcct(String acct) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.selectByAcct", acct);
        sqlSession.close();
        return users;
    }

    @Override
    public int insert(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int count = sqlSession.insert("test.insert", user);
        // 需要手动提交
        sqlSession.commit();
        sqlSession.close();
        return count;
    }
}
