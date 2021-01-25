package com.atguigu.service;
import  com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;

import java.util.List;

public interface BookService {

    //添加图书
    public void addBook(Book book);
    //按id删除图书
    public void deleteBookById(Integer id);
    //更新图书
    public void updateBook(Book book);
    //查询按条件图书
    public Book queryBookById(Integer id);
    //查询所有图书
    public List<Book> queryBooks();
    //处理分页
    Page<Book> page(int pageNO, int pageSize);

    Page<Book> pageByPrice(int pageNO, int pageSize, int min, int max);
}
