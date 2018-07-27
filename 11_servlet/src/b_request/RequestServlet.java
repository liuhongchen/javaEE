package b_request;

import a_hello.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收参数
        System.out.println(req.getParameter("username"));

        //回写数据
        resp.setContentType("text/html;charset=utf-8");//防止乱码
        resp.getWriter().print("hello,我是你爸爸");
    }
}
