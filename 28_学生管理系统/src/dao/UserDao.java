package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserDao {

    //登录
    public int login(String username,String password) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="Select * from users where username=? and password=?";
        int result=0;
        List<User> list=queryRunner.query(con,sql,new BeanListHandler<User>(User.class),username,password);
        if(list!=null){
            result=1;
        }
        return result;
    }
}
