import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> names=request.getHeaderNames();
        StringBuilder namess=new StringBuilder("头部：<br/>");
        while (names.hasMoreElements()){
            String name=names.nextElement();
            namess.append(name+":"+request.getHeader(name)+"<br/>");
        }
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(namess.toString());
    }
}
