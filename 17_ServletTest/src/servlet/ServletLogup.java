package servlet;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletLogup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService=new UserService();
        response.setContentType("text/html;charset=utf-8");
        try {
            int result=userService.logup(request.getParameter("username"),
                    request.getParameter("password"),
                    request.getParameter("nickname"));
            if(result==1){
                response.setStatus(302);
                response.setHeader("Location","http://localhost:8080/login.html");
            }else{
                response.getWriter().write("账号已存在，请返回并重新输入");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
