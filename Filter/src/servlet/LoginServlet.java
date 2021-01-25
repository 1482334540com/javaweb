package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : LoginServlet  //类名
 * @Description : Filter登录测试servlet程序  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/8  22:06
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if ("root".equals(username)&&password.equals("123")){
            req.getSession().setAttribute("user",username);
           resp.getWriter().write("登录成功!!");
        }
        else{
          req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }

    }
}


