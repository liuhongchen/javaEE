package service;

import dao.UserDao;

import java.sql.SQLException;

public class UserService {
    private UserDao userDao=new UserDao();

    //登录
    public int login(String username,String password) throws SQLException {
        return userDao.login(username,password);
    }
}
