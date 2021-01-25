package com.servlet2;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        1.getRequestURL() 获取请求的统一资源定位符（绝对路径
        System.out.println("URI"+req.getRequestURI());
        //输出：URI/servlet07_war_exploded/requestAPI

//        2.getRemoteHost() 获取客户端的 ip 地址
        System.out.println("客户端IP地址"+req.getRemoteHost());
//            使 用 localhost访 问 时 ， 得到的客户端ip地 址 是===>>> 127.0.0.1<br/>
//            使 用 127.0.0.1访 问 时 ， 得的客户ip地 址 是===>>> 127.0.0.1<br/>
//            使 用 真 实 ip访 问 时 ， 得到的客 户 端ip地 址 是===>>>真实的客 户端ip地 址

//        3.getHeader() 获取请求头 v. getParameter() 获取请求的参数
        System.out.println("请求头User-Agent地址："+req.getHeader("User-Agent"));


//        4.getMethod() 获取请求的方式 GET 或 POST
        System.out.println("获取请求的方式："+req.getMethod());

//        5.getRequestURI() 获取请求的资源路径
        System.out.println("URL"+req.getRequestURL());
        //输出：URLhttp://localhost/servlet07_war_exploded/requestAPI
    }
}
