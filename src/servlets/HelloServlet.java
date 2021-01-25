package servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class HelloServlet  implements Servlet {
    public HelloServlet(){
        System.out.println("1.构造器方法");
    }
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("2.初始化方法");

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    //service：专门用来处理请求和相应的
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("3.hello servlet 被访问了==每次执行都会调用");
//        System.out.println("get请求方法");
//        System.out.println("post请求方法");
        //类型转换
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        //获取请求方式
        String method = httpServletRequest.getMethod();
        System.out.println(method);//输出get
        if("GET".equals(method)){
           doGet();
        }
            else {
           doPost();
        }

}
//get请求处理方法
    public  void doGet(){
        System.out.println("get请求方法");
}
//post请求处理方法
    public  void doPost(){
        System.out.println("psot请求方法");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("4.销毁方法：web工程停止的时候调用");
    }
}
