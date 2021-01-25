package com.servlet2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数（办事材料）
        String username = req.getParameter("username");
        System.out.println("在servlet1（柜台）中查看参数（材料）"+username);

        //给材料盖一个章，并且传递到servlet2（柜台2）去查看
        req.setAttribute("key1","柜台1的章");

        //问路，问servlet2柜台怎么走,请求转发必须要以/打头
        //斜杠表示地址为 ： http://ip:port/ 工程名  映射到IDEA代码的we目 录
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/form.html");

        //走向柜台2
        requestDispatcher.forward(req,resp);





    }
}
