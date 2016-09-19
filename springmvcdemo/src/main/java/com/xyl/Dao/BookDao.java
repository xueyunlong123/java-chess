package com.xyl.Dao;

import com.xyl.Dao.inter.IBookDao;
import com.xyl.Util.MybatisUtil;
import com.xyl.bean.Book;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public class BookDao implements IBookDao {
    //建立连接
    SqlSession sqlSession = MybatisUtil.getSession();

    IBookDao iBookDao = sqlSession.getMapper(IBookDao.class);
    @Override
    public List<Book> getAllBook() {
        List<Book> books = iBookDao.getAllBook();
        return books;
    }

    @Override
    public Book queryBookById(int id) {
        Book book = iBookDao.queryBookById(id);
        return book;
    }
}
