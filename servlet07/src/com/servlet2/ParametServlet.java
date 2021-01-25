package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ParametServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //解决post请求传值出现中文乱码的情况（在获取请求参数之前才有用）
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hobby = req.getParameter("hobby");

        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("爱好："+hobby);
        System.out.println("选中多个爱好时："+ Arrays.asList(hobbys));

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
       String username = request.getParameter("username");
       String password = request.getParameter("password");
       String hobby = request.getParameter("hobby");

//       多值使用.getParameterValues方法
       String[] hobbys = request.getParameterValues("hobby");
        System.out.println("用户名："+username);
        System.out.println("密码："+password);
        System.out.println("爱好："+hobby);
        System.out.println("选中多个爱好时："+ Arrays.asList(hobbys));


    }
}
