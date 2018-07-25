import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceDemo {
    public static void main(String[] args) throws SQLException {
        BasicDataSource dataSource=new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        Connection con=dataSource.getConnection();
        System.out.println(con);
    }
}
