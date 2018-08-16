package demo01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestDemo {

    @Autowired
    private OrderDao orderDao;
    @Test
    public void test01(){
        orderDao.save();
    }

    @Test
    public void test02(){
        orderDao.update();
    }

    @Test
    public void test03(){
        orderDao.delete();
    }

    @Test
    public void test04(){
        orderDao.find();
    }
}
