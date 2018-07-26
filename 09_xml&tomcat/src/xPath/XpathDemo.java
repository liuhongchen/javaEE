package xPath;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XpathDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader saxReader=new SAXReader();
        Document doc=saxReader.read("09_xml&tomcat/web.xml");

        List<Element> eles=doc.selectNodes("//servlet");

        for(Element element:eles){
            System.out.println(element.elementText("servlet-name"));
            System.out.println(element.elementText("servlet-class"));
        }


    }
}
