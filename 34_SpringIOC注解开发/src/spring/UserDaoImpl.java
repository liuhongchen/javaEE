package spring;

import org.springframework.stereotype.Component;

@Component("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        System.out.println("userDaoImpl..");
    }
}
