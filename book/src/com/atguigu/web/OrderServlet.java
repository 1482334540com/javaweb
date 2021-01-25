package com.atguigu.web;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.User;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName : OrderServlet  //类名
 * @Description : 生成订单Servlet  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/8  17:50
 */
@WebServlet("/orderServlet")
public class OrderServlet extends  BaseServlet{

 private OrderService orderService = new OrderServiceImpl();

     protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            // 先获取Cart购物车对象
            Cart cart = (Cart) req.getSession().getAttribute("cart");

            // 获取Userid
             User loginUser =  (User) req.getSession().getAttribute("user");;

         if (loginUser == null) {
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
                return ;
            }


            Integer userId = loginUser.getId();
//        调用orderService.createOrder(Cart,Userid);生成订单
         String orderId = orderService.createOrder(cart, userId);

    /*     String orderId = null; //这样的方式需要给每个services.xxx方法都加上try cath 方法 这样做太笨拙 不灵活

         try {
             orderId = orderService.createOrder(cart, userId);
             JdbcUtils.commitAndClose(); //提交事务
         } catch (Exception e) {
             JdbcUtils.rollbackAndClose(); //回滚事务
             e.printStackTrace();
         }

     */

//        req.setAttribute("orderId", orderId);
            // 请求转发到/pages/cart/checkout.jsp
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req, resp);

            req.getSession().setAttribute("orderId",orderId);

            resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}


