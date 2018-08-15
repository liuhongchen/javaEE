package service;

import dao.StudentDao;
import domain.Student;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class StudentService {
    private StudentDao dao=new StudentDao();

    //add
    public int add(String name, String gender,
                   String phone, Date birthday, String hobby, String info) throws SQLException {
        return dao.add(name,gender,phone,birthday,hobby,info);

    }

    //query
    public List<Student> queryStudents(String name,String gender) throws SQLException {
        List<Student> list=null;
        if(name!=null&&(gender.equals("男")||gender.equals("女"))){
            list=dao.queryStudentByNameAndGender(name,gender);
        }else if(name!=null&&gender.equals("-请选择-")){
            list=dao.queryStudentByName(name);
        }else if(name==null&&(gender.equals("男")||gender.equals("女"))){
            list=dao.queryStudentByGender(gender);
        }else{
            list=dao.queryStudents();
        }
        return list;
    }

    //delete
    public int delete(int id) throws SQLException {
        return dao.delete(id);
    }
}
