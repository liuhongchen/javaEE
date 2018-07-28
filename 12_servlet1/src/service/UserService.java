package service;

import dao.UserDao;

import java.sql.SQLException;

public class UserService {
    private  UserDao userDao=new UserDao();

    public  int addUser(String username,String password) throws SQLException {
        int result=userDao.addUser(username,password);
        System.out.println("Dao返回"+result);
        return result;
    }
}
