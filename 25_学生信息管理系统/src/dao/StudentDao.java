package dao;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDao {

    //查询所有
    public List<Student> getAllStudents() throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from students";
        List<Student> list=queryRunner.query(con,sql,new BeanListHandler<Student>(Student.class));
        return list;
    }
}
