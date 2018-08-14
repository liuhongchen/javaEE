package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class ServletLogin extends HttpServlet {

    UserService userService=new UserService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        int result=0;
        try {
            result=userService.login(username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result==0){
            response.getWriter().write("账户或密码错误，登录失败！");
        }else {
            response.sendRedirect("http://localhost:8080/main.jsp");
        }
    }
}
