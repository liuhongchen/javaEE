package servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServletDownload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName=request.getParameter("filename");
        //设置头为跳转
        response.setHeader("Content-Disposition",
                "attachment;filename="+fileName);
        ServletContext context=getServletContext();
        InputStream is=context.getResourceAsStream("download/"+fileName);

        OutputStream os=response.getOutputStream();

        int len=0;
        byte[] bytes=new byte[1024];
        while((len=is.read(bytes))!=-1){
            os.write(bytes,0,len);
            os.flush();
        }
        os.close();
        is.close();

    }
}
