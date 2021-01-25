package com.atguigu.web;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {
            HttpSession session=req.getSession();
           session.setAttribute("sessions","session对象");
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);

            //   跳回登录页面
            resp.setContentType("text/html;charset=utf-8");
//            resp.getWriter().print("<script>alert('账号或者密码不正确');window.location.href='http://localhost/book/pages/user/login.jsp';</script>");
//        resp.getWriter().print("<h1>登录失败</h1><form action='http://localhost/book/pages/user/login.jsp'><input type='submit' value='返回'></form>");
            // 请求转发的方式
      req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            //请求重定向
//            resp.sendRedirect("pages/user/login.jsp");



        } else {
            // 登录 成功
            //跳到成功页面login_success.jsp

            // 请求转发的方式
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
            //请求重定向
//            resp.sendRedirect("pages/user/login_success.jsp");
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}

/* 如果是请求转发使用 req.setAttribute("msg","需要返回的数据");存取数据，在jsp中用request.getAttribute("msg")获取request中的数据

如果使用的是请求重定向的话使用 HttpSession session=req.getSession(); session.setAttribute("sessions","session对象");
这样的方式保存数据。jsp中用<%=session.getAttribute("sessions")%>的方式获取数据。(一次会话有效，关闭浏览器时session对象的生命周期结束)

请求转发和请求重定向的区别
请求转发：客户端只有一次请求，服务器端转发后会将请求对象保存，地址栏中的URL地址不会改变，得到响应后服务器端再将响应发给客户端；
请求重定向：是一种客户端行文，从本质上讲等同于两次请求，前一次请求对象不会保存只会保存后一次的请求对象，，地址栏的URL地址会改变。
* */
