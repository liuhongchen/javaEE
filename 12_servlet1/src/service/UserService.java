package service;

import dao.UserDao;

import java.sql.SQLException;

public class UserService {
    private static UserDao userDao=new UserDao();

    public static int addUser(String username,String password) throws SQLException {
        return userDao.addUser(username,password);

    }
}
