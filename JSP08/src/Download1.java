import org.apache.commons.io.IOUtils;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

//文件下载
@WebServlet("/download1")
public class Download1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* 1.获取需要下载的文件名*/
         String dowloadFileName ="default.jpg";

       /* 2.读取需要下载的文件内容（通过servletcontext对象可以读取）*/
        ServletContext context = getServletContext();

        //获取要下载的文件类型
        String mineTyoe =context.getMimeType("/file/"+dowloadFileName);
        System.out.println("下载的文件类型："+mineTyoe);

        /*4.回传之前通过响应头告诉客户端回传的数据类型*/
        resp.setContentType(mineTyoe);

       /* 5.告诉客户端数据是用于下载还是使用与响应头*/
       /* attachment:附件 filename ：指定下载的文件名*/ //URL编码是把汉字转化为%xx%xx的格式
        resp.setHeader("Content-Disposition","attachment;filename="+ dowloadFileName);
//        URLEncoder.encode("摩托车.jpg","UTF-8")
        InputStream resourceAsStream = context.getResourceAsStream("/file/"+dowloadFileName);

        /*3.把下载的内容回传给客户端*/
        /*获取响应的输出流*/
        OutputStream outputStream = resp.getOutputStream();

        /*读取输入流张总的全部数据，复制给输出流，输出给客户端*/
        IOUtils.copy(resourceAsStream,outputStream);
   }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }
}
