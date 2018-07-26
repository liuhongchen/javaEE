package example;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
    @Test
    public void f1() throws DocumentException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //定义一个Map集合
        Map<String,String> map=new HashMap<>();
        //往Map中放入一个值 key:/hello value: domain.HelloMyServlet
        SAXReader reader=new SAXReader();
        Document doc=reader.read("D:\\javaEE\\09_xml&tomcat\\web.xml");
        String key=null;
        String value=null;
        List<Element> eles =doc.selectNodes("//servlet-mapping");
        for(Element ele:eles){
            key=ele.elementText("url-pattern");
        }
        List<Element> eless =doc.selectNodes("//servlet");
        for(Element ele:eless){
            value=ele.elementText("servlet-class");
        }
        map.put(key,value);
        //通过key 获取value
//        map.get(key);
        //通过value创建一个实例
        Class clazz=Class.forName(value);
        //调用里面的空参add方法
        clazz.getMethod("add").invoke(clazz.newInstance());
    }
}
