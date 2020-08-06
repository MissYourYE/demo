import com.dubm.apply.mybatis.dao.xmproxy.HelloMapper;
import com.dubm.apply.mybatis.dao.xmproxy.UserMapper;
import com.dubm.apply.mybatis.po.Hello;
import com.dubm.apply.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class UserMapperTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("xmlproxy/SqlMapConfig.xml");
        sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        is.close();
    }

    @Test
    public void test() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

    @Test
    public void insert() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        ArrayList<User> users = new ArrayList<>();
        for (int i = 1; i <= 10000; i++) {
            User user = new User("name" + i, (short) 18, "positions" + i, "acct" + i, "pwd" + i, "addr" + i, i, "email" + i, new Date(), (short) 0);
            users.add(user);
            if (i%10000==0){
                mapper.batchInsert(users);
                users = new ArrayList<>();
            }
        }
    }

    @Test
    public void test1() {
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        Runnable runnable = () -> {
            try {
                Thread.sleep(1000);
                System.out.println("111111");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        executorService.submit(runnable);
        System.out.println("=================");
    }
}
