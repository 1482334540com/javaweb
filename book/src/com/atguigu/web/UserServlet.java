package com.atguigu.web;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.utils.WebUtils;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


@WebServlet("/userServlet")
public class UserServlet  extends BaseServlet  {

    private UserService userService = new UserServiceImpl();

 protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User loginUser = userService.login(new User(null, username, password, null));
        // 如果等于null,说明登录 失败!
        if (loginUser == null) {

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
            System.out.println("请求失败");


        } else {
            //保存用户登录成功之后的信息到session域中
            req.getSession().setAttribute("user",loginUser);
            //跳到成功页面login_success.jsp
            // 请求转发的方式
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
            //请求重定向
//            resp.sendRedirect("pages/user/login_success.jsp");
        }

    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //调用 WenUtilscopyparamToBean(HttpServletRequest request,Object bean)方法将请求发过来都数据存到user对象中
        User user =  WebUtils.copyparamToBean(req.getParameterMap(),new User());

        // 获取Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        // 删除 Session中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        //  1、获取请求的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (token != null && token.equalsIgnoreCase(code)){
//        3、检查 用户名是否可用
            if (userService.existsUsername(username)) {

               // 把回显信息，保存到Request域中
                req.setAttribute("msg", "用户名已存在！！");
                req.setAttribute("username", username);
                req.setAttribute("email", email);


//        跳回注册页面
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            } else {
                //  可用
//                调用Sservice保存到数据库
                userService.registUser(new User(null, username, password, email));
//
//              跳到注册成功页面 regist_success.jsp
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
            }
        } else {
            //把回显数据放入request中
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username","username");
            req.setAttribute("email",email);
            System.out.println("验证码[" + code + "]错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
        }

    }

    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //删除session中的数据
        req.getSession().invalidate();
        //重定向到主页
        resp.sendRedirect("index.jsp");

    }
    //验证用户名是否可用
    protected void ajaxExistsUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求的参数username
        String username = req.getParameter("username");
        // 调用userService.existsUsername();
        boolean existsUsername = userService.existsUsername(username);
        // 把返回的结果封装成为map对象
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("existsUsername",existsUsername);

        Gson gson = new Gson();
        String json = gson.toJson(resultMap);

        resp.getWriter().write(json);

    }





}
