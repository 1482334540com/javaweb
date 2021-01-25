package com.atguigu.fiter;

import javax.servlet.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @ClassName : AdminFilter  //类名
 * @Description : 过滤器的初体验  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/8  21:16
 */
public class AdminFilter implements Filter {
    public AdminFilter() {
        //web 工程启动的时候执行
        System.out.println("1.Filter的构造方法");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //web 工程启动的时候执行
        System.out.println("2.Filter 的 init(FilterConfig filterConfig)初始化");

        // 1 、 获 取 Filter的 名 称filter-name的 内 容
        System.out.println("filter-name 的值是：" + filterConfig.getFilterName());
        // 2 、 获 取 在 web.xml 中 配 置 的 init-param 初 始 化 参 数
         System.out.println("初始化参数 username 的值是："+filterConfig.getInitParameter("username"));
         System.out.println("初始化参数 url 的值是：" + filterConfig.getInitParameter("url"));
        // 3 、 获 取 ServletContext 对 象
        System.out.println( "ServletContext对象："+ filterConfig.getServletContext());
    }

    @Override  //doFilter:专门用于拦截请求，可以做权限检查
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //每次拦截到请求，就会执行
        System.out.println("3.Filter 的 doFilter 过滤方法");

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        HttpSession session = httpServletRequest.getSession();
        Object object = session.getAttribute("user");
        /*如果object为空 说明还没有登录*/
        if (object == null )
        {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            return;
        }
        else{
            //让用户继续访问目标资源(没有这行代码程序是不会往下走的，网页会一片空白)
          filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        //，停止 web 工程的时候，就会执行（停止 web 工程，也会销毁 Filter 过滤器）
        System.out.println("4.Filter 的 destroy 销毁方法");
    }
}


