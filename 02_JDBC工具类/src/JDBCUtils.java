import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
    1.实现JDBC工具类
    定义方法，可以直接返回数据库的连接对象

    2.构造方法
        因为JDBC一般是静态的，所以直接将构造方法定义为私有的，就不能创建对象
        而是可以直接通过类名调用
    3.
 */
public class JDBCUtils {
    private static Connection con;
    private JDBCUtils() {
    }

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/db?serverTimezone=UTC",
                    "root",
                    "123456"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    * 定义静态方法，返回数据库的连接对象
    * */
    public Connection getConnection(){
        return con;
    }
}
