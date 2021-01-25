package com.atguigu.service.impl;
import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import com.atguigu.service.BookService;
import java.util.List;

public class BookServiceImpl  implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }
    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }
    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }
    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }
    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks(); }

    //分页方法
    @Override
    public Page<Book> page(int pageNO, int pageSize) {
        Page<Book> page = new Page<Book>();

        //设置当前每页显示数量
        page.setPageSiz(pageSize);
        //求总记录数
        Integer pageTotalCount =bookDao.queryForPageTotalCount();
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal+=1;
        }
        // 数据有效边界检查（可以写在setPageNo中更为合适）
        if (pageNO < 1) { pageNO = 1; }
        if (pageNO > pageTotal) { pageNO = pageTotal; }

        //设置当前页码
        page.setPageNo(pageNO);

        //设置总页码
        page.setPageTotal(pageTotal);
        //求当前页的开始索引

        int begin = (page.getPageNo() - 1) * pageSize;
        //设置当前前页数据
        System.out.println(begin);
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);
        page.setItems(items);
        return page;
    }



    //价格区间查询方法
    @Override
    public Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max) {

        Page<Book> page = new Page<Book>();


        //设置当前每页显示数量
        page.setPageSiz(pageSize);
        //求总记录数
        Integer pageTotalCount =bookDao.queryForPageTotalCountByPrice(min , max);
        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount%pageSize > 0){
            pageTotal+=1;
        }
        // 数据有效边界检查（可以写在setPageNo中更为合适）
        if (pageNO < 1) { pageNO = 1; }
        if (pageNO > pageTotal) { pageNO = pageTotal; }

        //设置当前页码
        page.setPageNo(pageNO);

        //设置总页码
        page.setPageTotal(pageTotal);
        //求当前页的开始索引

        int begin = (page.getPageNo() - 1) * pageSize;
        //设置当前前页数据

        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);
        page.setItems(items);
        return page;
    }
}
