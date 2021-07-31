package com.heima.service.impl;

import com.heima.dao.BookDao;
import com.heima.dao.impl.BookDaoImpl;
import com.heima.service.BookService;

public class BookServiceImpl implements BookService {
    BookDao bookDao = new BookDaoImpl();
    @Override
    public int addBook(com.heima.entity.Book book) {
        int i = bookDao.saveBook(book);
        return i;
    }
}
