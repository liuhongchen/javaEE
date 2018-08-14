package tools;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    private static Connection con;
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    static void readConfig() throws IOException {
        Properties pro=new Properties();
        InputStream is=JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
        pro.load(is);
        driverClass=pro.getProperty("driverClass");
        url=pro.getProperty("url");
        username=pro.getProperty("username");
        password=pro.getProperty("password");
    }

    static {
        try {
            readConfig();
            Class.forName(driverClass);
            con=DriverManager.getConnection(url,username,password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

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
