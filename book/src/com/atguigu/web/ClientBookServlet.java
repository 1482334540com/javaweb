package com.atguigu.web;

import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/clientBookServlet")
public class ClientBookServlet extends  BaseServlet {
    private BookService bookService = new BookServiceImpl();

    //处理分页功能（前台）
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*1.获取请求的参数pageNO和pageSize*/
        int pageNO= WebUtils.parseInt(req.getParameter("pageNO"),1);
        int pageSize= WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZ);
        /* 2.调用bookServices.page(pageNO，pageSize)得到page对象*/

        Page<Book> page = bookService.page(pageNO,pageSize);
        //设置分页条地址
        page.setUrl("/clientBookServlet?action=page");
        /*3.把page对象放到request域中*/

        req.setAttribute("page",page);
        /*4.请求转发到/pages/manager/book_edit.jsp页面中*/
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);



    }

    //处理分页功能（前台）
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*1.获取请求的参数pageNO和pageSize*/
        int pageNO= WebUtils.parseInt(req.getParameter("pageNo"),1);
        int pageSize= WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZ);
        int min= WebUtils.parseInt(req.getParameter("min"),0);
        int max= WebUtils.parseInt(req.getParameter("max"), Integer.MAX_VALUE);

        /* 2.调用bookServices.page(pageNO，pageSize)得到page对象*/
        Page<Book> page = bookService.pageByPrice(pageNO,pageSize,min,max);
        StringBuilder sb = new StringBuilder("/clientBookServlet?action=pageByPrice");
        // 如果有最小价格的参数,追加到分页条的地址参数中
        if (req.getParameter("min") != null) {
            sb.append("&min=").append(req.getParameter("min"));
        }
        // 如果有最大价格的参数,追加到分页条的地址参数中
        if (req.getParameter("max") != null) {
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());

        //设置分页条地址
//        page.setUrl("/clientBookServlet?action=pageByPrice");
        /*3.把page对象放到request域中*/

        req.setAttribute("page",page);
        /*4.请求转发到/pages/manager/book_edit.jsp页面中*/
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);



    }
}
/**
 * @ClassName : ClientBookServlet  //类名
 * @Description : clientBookServlet  //描述
 * @Author : ${"胡雨"} //作者
 * @Date: 2020/11/2  9:22
 */

