package service;

import dao.StudentDao;
import domain.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {
    private StudentDao studentDao=new StudentDao();
    //获取所有学生
    public List<Student> getAllStudents() throws SQLException {
        return studentDao.getAllStudents();
    }
}
