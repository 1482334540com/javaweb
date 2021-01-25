package com.atguigu.dao;
import  com.atguigu.pojo.Book;

import java.util.List;

public interface BookDao {
    //添加图书
    public int addBook(Book book);
    //按id删除图书
    public int deleteBookById(Integer id);
    //更新图书
    public int updateBook(Book book);
    //查询按条件图书
    public Book queryBookById(Integer id);
    //查询所有图书
    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
}
