package com.servlet2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseIOServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

/*         设置字符集为UTF-8，设置完之后就支持了
        resp.setCharacterEncoding("UTF-8");
        System.out.println(resp.getCharacterEncoding());  //默认使用： ISO-8859-1（只支持英文不支持中文）
        //通过响应头设置浏览器也是UTF-8字符集
        resp.setHeader("Content-Type","text/html;charset=UTF-8");  */

        //同时设置服务器和客户端的编码格式为UTF-8
        //注意此方法一定要在获取流对象之前使用才有效
        resp.setContentType("text/html;charset=UTF-8");

//        字符流：往客户端回传字符串数据
        PrintWriter writer = resp.getWriter();
        //回传英文
//        writer.write("response content!!");
        //回传中文(会出现乱码)
        writer.write("向客户端回传中文数据");
        //字节流
//        resp.getOutputStream();
    }
}
