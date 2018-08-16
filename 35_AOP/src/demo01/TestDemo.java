package demo01;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
 class TestDemo {

    @Autowired
    @Qualifier("productDao")
    private ProductDao productDao;

    @Test
     void test01(){
        if(productDao==null){
            System.out.println("null");
        }else {
            productDao.save();
            productDao.delete();
            productDao.find();
            productDao.update();
        }
    }
}
