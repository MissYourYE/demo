import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest {
    public static void main(String[] args) throws Exception {
        // 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接对象
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://123.56.3.245:3316/test",
                "work",
                "j0FRO3XhYAHmNOrI");
        // 通过连接对象创建发送sql的工具对象
        Statement statement = connection.createStatement();
        // 使用sql工具执行sql并返回结果集
        ResultSet resultSet = statement.executeQuery("select * from user where id = 1");
        // 处理结果
        while (resultSet.next()) {
            long id = resultSet.getLong("id");
            String acct = resultSet.getString("acct");
            System.out.println(id + "-" + acct);
        }
        // 释放资源
        resultSet.close();
        statement.close();
        connection.close();
    }
}
