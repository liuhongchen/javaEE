import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletLogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd---HH:mm:ss");//设置日期格式
        Cookie cookie=new Cookie("lastLogin",df.format(new Date()));
        Cookie[] cookies=request.getCookies();
        if(username.equals("admin")&&password.equals("123")){
            if(cookies==null){
                response.addCookie(cookie);
                response.getWriter().write("登录成功");
            }else{
                response.addCookie(cookie);
                for(Cookie cookie1:cookies){
                    if(cookie1.getName().equals("lastLogin")){
                        String lastTime=cookie1.getValue();
                        response.getWriter().write("登录成功"+",上次登录时间为："+lastTime);
                        cookie1.setValue(df.format(new Date()));
                        response.addCookie(cookie1);
                    }
                }
            }

        }else {
            response.getWriter().write("登录失败");
        }
    }
}
