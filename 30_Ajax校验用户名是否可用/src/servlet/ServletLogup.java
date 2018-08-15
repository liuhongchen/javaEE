package servlet;

import java.io.IOException;

public class ServletLogup extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username=request.getParameter("username");
        response.setContentType("text/html;charset=utf-8");
        if(username.equals("admin")){
            response.getWriter().write("账号已存在！");
        }
    }
}
