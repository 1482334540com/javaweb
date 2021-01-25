package com.atguigu.test;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.pojo.Book;
import com.atguigu.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;


public class BookDaoTest {
private BookDao bookDao=new BookDaoImpl();


    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"java原理", "佚名", new BigDecimal(9999),1100000,0,null ));

    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(21);

    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(21,"道德经", "孔子", new BigDecimal(9999),1100000,0,null ));
    }

    @Test
    public void queryBookById() {
        System.out.println( bookDao.queryBookById(21) );

    }

    @Test
    public void queryBooks() {
        for (Book queryBook : bookDao.queryBooks()) { System.out.println(queryBook);
        }

    }
    @Test
    public void queryForPageTotalCount() {

        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {

        for (Book book : bookDao.queryForPageItems(0, 4)) {
            System.out.println(book);
        }
   }

    @Test
    public void queryForPageTotalCountByPrice() {

        System.out.println(bookDao.queryForPageTotalCountByPrice(10,20));
    }

    @Test
    public void queryForPageItemsByPrice() {

        for (Book book : bookDao.queryForPageItemsByPrice(0, Page.PAGE_SIZ,0,100)) {
            System.out.println(book);
        }
    }

}