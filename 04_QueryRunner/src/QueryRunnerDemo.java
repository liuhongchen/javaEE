import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class QueryRunnerDemo {

    public static void main(String[] args) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="update sort sname='nihao' where sname='hello'";
        queryRunner.update(con,sql);

    }
}
