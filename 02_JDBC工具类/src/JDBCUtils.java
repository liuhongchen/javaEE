import java.io.*;
import java.sql.*;

/*
    1.实现JDBC工具类
    定义方法，可以直接返回数据库的连接对象

    2.构造方法
        因为JDBC一般是静态的，所以直接将构造方法定义为私有的，就不能创建对象
        而是可以直接通过类名调用
    3.使用properties配置文件
        开发中获得连接的四个参数（驱动、URL、用户名、密码）通常都放在配置
        文件中，方便后期维护，程序如果需要更换数据，只需要修改配置文件即可。
        文件位置：任意，建议src
        文件名称，任意，扩展名为properties
        文件内容：一行一组数据，格式是“key=value”
            a）key命名自定义，如果是多个单词，习惯用点分隔。例如jdbc.driver
            b）value值不支持中文，如果需要使用非英文字符，将进行Unicode转换。
    4.读取properties文件（通过IO流读取，存储到Map中)

 */
public class JDBCUtils {

    private static Connection con;
    private JDBCUtils() {
    }

    static {
        File file =new File("D:\\javaEE\\02_JDBC工具类\\src\\database.properties");
        String driverClass=null;
        String url=null;
        String username=null;
        String password=null;
        try {
            BufferedReader br= new BufferedReader(new FileReader(file));
            String str=null;
            while((str=br.readLine())!=null){
                String[] strArr=str.split("=");
                switch (strArr[0]){
                    case "driverClass":
                        driverClass=strArr[1];
                        break;
                    case "url":
                        url=strArr[1];
                        break;
                    case "username":
                        username=strArr[1];
                        break;
                    case "password":
                        password=strArr[1];
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(driverClass);
            con=DriverManager.getConnection(url+"?serverTimezone=UTC", username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*
    * 定义静态方法，返回数据库的连接对象
    * */
    public static Connection getConnection(){
        return con;
    }

    /*
    * 写关闭方法
    * */
    public static void close(Connection con, Statement stat, ResultSet rs) throws SQLException {
        con.close();
        stat.close();
        rs.close();
    }
}
