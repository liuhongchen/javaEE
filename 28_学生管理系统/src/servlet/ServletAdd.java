package servlet;

import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServletAdd extends HttpServlet {

    private StudentService service=new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String name =request.getParameter("stu_name");
        String gender=request.getParameter("stu_gender");
        if(gender.equals("on")){
            gender="男";
        }else{
            gender="女";
        }
        String phone=request.getParameter("stu_phone");
        String birthdayStr=request.getParameter("stu_birthday");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthday= null;
        try {
            birthday = simpleDateFormat.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String hobby=request.getParameter("stu_hobby");
        String info=request.getParameter("stu_info");
        try {
           service.add(name,gender,phone,birthday,hobby,info);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("http://localhost:8080/main.jsp");
    }
}
