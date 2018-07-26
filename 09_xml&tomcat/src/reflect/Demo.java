package reflect;

import domain.HelloMyServlet;
import org.junit.jupiter.api.Test;

public class Demo {
    @Test
    public void f1(){
        //调用HelloMyServlet中的方法
        HelloMyServlet h=new HelloMyServlet();
        System.out.println(h.add(10));
    }

    @Test
    public void f2() throws Exception{
        Class clazz=Class.forName("domain.HelloMyServlet");
        HelloMyServlet h= (HelloMyServlet) clazz.newInstance();
        h.add();
    }

    @Test
    public void f3() throws Exception{
        Class clazz=Class.forName("domain.HelloMyServlet");
        System.out.println(
                clazz.getMethod("add",int.class)
                .invoke(clazz.newInstance(),10));
    }
}
