package spring.demo01;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo1 {
    @Test
    /*
    * 传统方式调用
    * */
    public void test01(){
        UserService userService=new UserServiceImpl();
        userService.save();
    }

    /*
    * Spring方式调用
    * */
    @Test
    public void test02(){
        ApplicationContext applicationContext=
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) applicationContext.getBean("userService");
        userService.save();
    }
}
