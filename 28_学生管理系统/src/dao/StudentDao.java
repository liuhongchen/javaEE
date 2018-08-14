package dao;

import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import tools.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentDao {

    //添加学生
    public int add(String name, String gender,
                   String phone, Date birthday, String hobby, String info) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="insert into  student values (null,?,?,?,?,?,?)";

        return queryRunner.update(con,sql,name,gender,phone,birthday,hobby,info);
    }

    //查找学生
    public List<Student> queryStudentByName(String name) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from student where name like '%"+name+"%'";
        List<Student> list=queryRunner.query(con,sql,new BeanListHandler<Student>(Student.class));
        return list;
    }
    public List<Student> queryStudentByGender(String gender) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from student where gender=?";
        List<Student> list=queryRunner.query(con,sql,new BeanListHandler<Student>(Student.class),gender);
        return list;
    }
    public List<Student> queryStudentByNameAndGender(String name,String gender) throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from student where name like '%\"+name+\"%' and gender=?";
        List<Student> list=queryRunner.query(con,sql,new BeanListHandler<Student>(Student.class),gender);
        return list;
    }
    public List<Student> queryStudents() throws SQLException {
        QueryRunner queryRunner=new QueryRunner();
        Connection con=JDBCUtils.getConnection();
        String sql="select * from student";
        List<Student> list=queryRunner.query(con,sql,new BeanListHandler<Student>(Student.class));
        return list;
    }

}
