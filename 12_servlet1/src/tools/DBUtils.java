package tools;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBUtils {
    private static BasicDataSource basicDataSource;

    static {
        InputStream in=DBUtils.class.getClassLoader().getResourceAsStream("db.properties");
        Properties pro=new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        basicDataSource.setDriverClassName(pro.getProperty("driverClass"));
        basicDataSource.setUrl(pro.getProperty("url"));
        basicDataSource.setUsername(pro.getProperty("username"));
        basicDataSource.setPassword(pro.getProperty("password"));

    }

    /*
    * 返回一个BasicDataSource对象
    * */
    public static BasicDataSource getDataSource(){
        return basicDataSource;
    }
}
