package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数（办事材料）
        String username = req.getParameter("username");
        System.out.println("在servlet1（柜台2）中查看参数（材料）"+username);

        //查看servlet1柜台是否有盖章
        Object key1 = req.getAttribute("key1");
        System.out.println("柜台1是否有盖章："+key1);

        //处理自己的业务逻辑
        System.out.println("servlet处理自己的业务逻辑：");

    }
}
