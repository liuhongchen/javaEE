import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ServletDemo02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取要下载的文件名字
        String fileName=request.getParameter("filename");
        //获取这个文件的正确路径并转换成输入流
        response.setHeader("Content-Disposition",
                "attachment;filename="+fileName);
        ServletContext context=getServletContext();
        InputStream is=context.getResourceAsStream("download/"+fileName);

        //回写
        OutputStream os=response.getOutputStream();
        int len=0;
        byte[] buffer=new byte[1024];
        while((len=is.read(buffer))!=-1){
            os.write(buffer,0,len);
        }
        os.close();
        is.close();
    }
}
