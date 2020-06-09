import com.dubm.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {


    @Test
    public void test0() {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        UserServiceImpl userService = (UserServiceImpl) cxt.getBean("userService");
        System.out.println(userService);
    }
}
