import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html;charset=utf-8");
        if ("admin".equals(username) && "123".equals(password)) {
//            response.getWriter().write("登录成功！");
            ServletContext servletContext = getServletContext();
            Object obj = servletContext.getAttribute("count");
            int totalCount = 0;
            if (obj != null) {
                totalCount = (int) obj;
            }
            servletContext.setAttribute("count", totalCount + 1);
            System.out.println("已知登录成功" + totalCount + "次");
            //成功就跳转到success.html
            response.setStatus(302);//重新定位状态码
            response.setHeader("Location", "http://localhost:8080/success.html");

        } else {

            response.getWriter().write("登录失败！");
        }
    }
}
