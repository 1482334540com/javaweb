package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Response1  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("曾到此一游：Response1");
//        第一种方式
    /*    //设置响应码302，表示重定向，已搬迁
        resp.setStatus(302);
        //设置响应头，说明新的地址在哪儿
//        resp.setHeader("Location","http://localhost/servlet07_war_exploded/response2");
//        可以访问工程以外的地址
        resp.setHeader("Location","https://www.baidu.com");  */

//        第二种方式:直接写地址

        resp.sendRedirect("https://www.baidu.com");

    }
}
