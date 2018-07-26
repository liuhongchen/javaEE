package tools;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCUtils {
    private static BasicDataSource dataSource;

    private JDBCUtils(){}

    static {
        InputStream in=JDBCUtils.class.getClassLoader().getResourceAsStream("database.properties");
        Properties pro=new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        dataSource=new BasicDataSource();
        dataSource.setDriverClassName(pro.getProperty("driverClass"));
        dataSource.setUrl(pro.getProperty("url"));
        dataSource.setUsername(pro.getProperty("username"));
        dataSource.setPassword(pro.getProperty("password"));

    }

    /*
    * getDataSource方法返回BasicDataSource对象
    * */
    public static DataSource getDataSource(){
        return dataSource;
    }
}
