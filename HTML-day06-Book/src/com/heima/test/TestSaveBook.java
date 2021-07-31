package com.heima.test;

import com.heima.dao.BookDao;
import com.heima.dao.impl.BookDaoImpl;
import com.heima.entity.Book;
import org.junit.Test;

import java.sql.Date;

public class TestSaveBook {
    BookDao bookDao = new BookDaoImpl();
    @Test
    public void testSaveBook(){
        bookDao.saveBook(new Book(0, "斗罗大陆", "唐家三少", Date.valueOf("2001-1-2"), 1));
    }
}
