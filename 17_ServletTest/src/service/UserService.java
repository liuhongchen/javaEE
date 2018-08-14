package service;

import dao.UserDao;

public class UserService {
    private UserDao userDao=new UserDao();
    public int logup(String username,String password,String nickname) throws Exception {

        return userDao.logup(username,password,nickname);
    }

    public int login(String username,String password) throws Exception{
        return userDao.login(username,password);
    }
}
