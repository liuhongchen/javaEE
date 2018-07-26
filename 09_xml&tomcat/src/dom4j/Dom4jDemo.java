package dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4jDemo {
    public static void main(String[] args) throws DocumentException {
        SAXReader reader=new SAXReader();
        Document doc=reader.read("09_xml&tomcat/web.xml");
        Element root =doc.getRootElement();
        List<Element> elements=root.elements();
        for(Element element:elements){
            System.out.println(element.elementText("servlet-name"));
        }
    }
}
