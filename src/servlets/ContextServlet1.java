package servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//获取servletcontext对象
        ServletContext servletContext = getServletContext();
        System.out.println(servletContext);

        System.out.println("未加入数据之前"+servletContext.getAttribute("value"));
       servletContext.setAttribute("key1","value");

        System.out.println("加入之后的数据是："+servletContext.getAttribute("key1"));
    }
}
