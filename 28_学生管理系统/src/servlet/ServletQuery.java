package servlet;

import domain.Student;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ServletQuery extends HttpServlet {
    StudentService studentService=new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("stu_name");
        String gender=request.getParameter("select");

        List<Student> list= null;
        try {
            list = studentService.queryStudents(name,gender);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for(Student student:list){
            System.out.println(student);
        }
        request.getSession().setAttribute("list",list);
        response.sendRedirect("http://localhost:8080/main.jsp");
    }
}
