package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCTools;

import java.sql.Connection;
import java.util.List;
public class UserDao {


    public int logup(String username,String password,String nickname) throws Exception {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCTools.getConnection();
        String sql="select * from users where ? = ?";
        List<User> userList=queryRunner.query(con,sql,new BeanListHandler<User>(User.class), "username",username);
        int result=0;
        if(userList!=null){
            String insertSql="insert into users " +
                    "values" +
                    "(null,?,?,?)";
            result=queryRunner.update(con,insertSql,username,password,nickname);
        }
        return result;
    }

    public int login(String username,String password) throws Exception{
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCTools.getConnection();
        String sql="select * from users where username = ? & password=?";
        List<User> userList=queryRunner.query(con,sql,new BeanListHandler<User>(User.class),username,password);
        int result=0;
        if(userList!=null){
            result=1;
        }
        return result;
    }
}
