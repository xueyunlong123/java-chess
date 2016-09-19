package com.xyl.Dao.inter;

import com.xyl.bean.Book;

import java.util.List;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public interface IBookDao {
    public List<Book> getAllBook();
    public Book queryBookById(int id);
}
