import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
@WebServlet("/JspServletTest01")
public class JspServletTest01 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 设置返回的数据内容的数据类型和编码
            resp.setContentType("text/html; charset=utf-8");
              // 获取字符输出流
            Writer writer = resp.getWriter();
            //输出页面内容！
             writer.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
             writer.write("<html>"); writer.write("<head>");

                writer.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");

                writer.write("<title>Insert title here</title>");

                writer.write("</head>"); writer.write("<body>");

                writer.write("这是由 Servlet 程序输出的 html 页面内容！");

                writer.write("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
