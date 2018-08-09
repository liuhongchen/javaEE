import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServletContextDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        test01();
//        test02();
        test03();
    }

    private void test03() throws IOException {
        InputStream is=ServletContextDemo.class.getClassLoader()
                .getResourceAsStream("pro.properties");
        Properties pro=new Properties();
        pro.load(is);
        String name=pro.getProperty("name");
        System.out.println(name);
    }

    private void test01() throws IOException {
        ServletContext servletContext=getServletContext();
        Properties properties=new Properties();
        InputStream is=servletContext.getResourceAsStream("pro.properties");
        properties.load(is);
        String name=properties.getProperty("name");
        System.out.println(name);
    }

    private void test02() throws IOException {
        ServletContext servletContext=getServletContext();
        String path=servletContext.getRealPath("pro.properties");
        InputStream is=new FileInputStream(path);
        Properties pro=new Properties();
        pro.load(is);
        String name=pro.getProperty("name");
        System.out.println(name);
    }
}
