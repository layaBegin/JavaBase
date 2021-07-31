package com.heima.dao.impl;

import com.heima.dao.BookDao;
import com.heima.utils.MyBatisUtils;
import com.heima.entity.Book;
import org.apache.ibatis.session.SqlSession;

import java.sql.Date;

public class BookDaoImpl implements BookDao {
    @Override
    public int saveBook(Book book) {
        SqlSession session = MyBatisUtils.getSession();
        BookDao bookDao = session.getMapper(BookDao.class);
        int count = bookDao.saveBook(book);
        session.commit();
        session.close();
        return count;
    }
}
