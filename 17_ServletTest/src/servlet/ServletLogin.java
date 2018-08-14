package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        response.setContentType("text/html;charset=utf-8");
        try {
            int result=userService.login(request.getParameter("username"),request.getParameter("password"));
            if(result==0){
                response.getWriter().write("账号或密码错误！请重新输入！");
            }else{
                response.setStatus(302);
                response.setHeader("Location","http://localhost:8080/Download");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
