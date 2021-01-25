package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取context键值对
        ServletContext servletContext = getServletConfig().getServletContext();
        String name= servletContext.getInitParameter("username");
        String pwd =servletContext.getInitParameter("password");
        System.out.println("user："+name);
        System.out.println("password："+pwd);
        //获取当前工程
        System.out.println("当前工程路径："+servletContext.getContextPath());
        //获取工程部署在硬盘上的绝度路径
        //"/“被服务器解析为地址为：http/ip:port/工程名 映射到IDEA代码的web目录
        System.out.println("整个工程部署的路径是："+servletContext.getRealPath("/"));
        System.out.println("web工程下css文件绝对路径是："+servletContext.getRealPath("/css"));
    }
}
