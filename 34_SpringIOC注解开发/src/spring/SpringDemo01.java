package spring;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo01 {
    @Test
    public void test01(){
        ApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) applicationContext.getBean("userDao");
        userDao.save();
    }
}
