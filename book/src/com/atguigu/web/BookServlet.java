package com.atguigu.web;
import  com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import  com.atguigu.service.BookService;
import com.atguigu.service.impl.BookServiceImpl;
import com.atguigu.utils.WebUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookServlet")
public class BookServlet extends BaseServlet{
    private  BookService bookService = new BookServiceImpl();


    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int pageNO = WebUtils.parseInt(req.getParameter("pageNO"),0);
        pageNO += 1;

        // 1 、 获取请求的参数 == 封装成为Book对象
         Book book = WebUtils.copyparamToBean(req.getParameterMap(),new Book());
         // 2 、调用BookService.addBook() 保 存 图 书
         bookService.addBook(book);
        // 3 、 跳 到 图 书 列 表 页 面
//        注意如果使用请求转发都话，就会出现用户每刷新一次就添加一次数据
       /* 请求转发都/表示到工程路径名*/
//        req.getRequestDispatcher("/bookservlet?action=list").forward(req, resp);
      /*  请求重定向的/表示到端口号*/
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page&pageNO=" +  pageNO);




    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         /*1.获取请求参数id*/
         int id = WebUtils.parseInt(req.getParameter("id"), 0);
         /* 2调用bookService.deleteBookById()方法删除图书*/
        /*  ctrl+alt+T快捷生成ty catch*/
            bookService.deleteBookById(id);

        /*3.重定向到图书列表页面*/

        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page&pageNO=" + req.getParameter("pageNO"));



    }
    //保存修改图书的操作
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* 1 获取请求的参数 == 封装成为Book对象*/
        Book book = WebUtils.copyparamToBean(req.getParameterMap(),new Book());
       /* 2 、调用BookService.updateBook( book )修改图书*/
        bookService.updateBook(book);
        /*3. 重 定 向 回 图 书 列 表 管 理 页 面*/
        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page&pageNO=" + req.getParameter("pageNO"));



    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1通 过 BookService查 询 全 部 图 书
        List<Book> books = bookService.queryBooks();
        //2 把 全 部 图 书 保 存 到 Request 域 中
         req.setAttribute("books", books);
         //3 、 请 求 转 发 到 /pages/manager/book_manager.jsp页面

        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);

    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.获取图书编号*/
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        /* 2.调用bookServices.queryBookById(id)得到修改都图书信息*/
        Book book = bookService.queryBookById(id);

        /*3.把修改后都得图书信息放到request域中*/
        req.setAttribute("book",book);
        /*4.请求转发到/pages/manager/book_edit.jsp页面中*/
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

    }
    //处理分页功能(后台)
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*1.获取请求的参数pageNO和pageSize*/
        int pageNO= WebUtils.parseInt(req.getParameter("pageNO"),1);
        int pageSize= WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZ);

        /* 2.调用bookServices.page(pageNO，pageSize)得到page对象*/
        Page<Book> page = bookService.page(pageNO,pageSize);

        page.setUrl("/bookServlet?action=page");
        /*3.把page对象放到request域中*/

        req.setAttribute("page",page);
        /*4.请求转发到/pages/manager/book_edit.jsp页面中*/
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);



    }


}

