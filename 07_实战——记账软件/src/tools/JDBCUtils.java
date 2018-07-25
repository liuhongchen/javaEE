package tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private static Connection con;
    private static BasicDataSource dataSource;
    private static String driverClass;
    private static String url;
    private static String username;
    private static String password;

    private JDBCUtils(){}

    static {
        InputStream in=JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
        Properties pro=new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverClass=pro.getProperty("driverClass");
        url=pro.getProperty("url");
        username=pro.getProperty("username");
        password=pro.getProperty("password");

        dataSource=new BasicDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

    }


    /*
    * getConnection方法返回Connection对象
    * */
    public static Connection getConnection(){
        return con;
    }

    /*
    * getDataSource方法返回BasicDataSource对象
    * */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
