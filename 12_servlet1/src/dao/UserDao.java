package dao;

import org.apache.commons.dbutils.QueryRunner;
import tools.DBUtils;

import java.sql.SQLException;

public class UserDao {
    private static QueryRunner queryRunner=new QueryRunner(DBUtils.getDataSource());

    public static int addUser(String username,String password) throws SQLException {
        String sql="insert into users values (?,?,?);";
        return queryRunner.update(DBUtils.getDataSource().getConnection(),
                sql,null,username,password);
    }




}