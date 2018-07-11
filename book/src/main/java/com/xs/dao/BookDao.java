package com.xs.dao;

import com.xs.entity.Author;
import com.xs.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {
    //查询所有图书
    List<Book> bookList();

    //按照ID或者name查询
    List<Book> bookNameAndId(Book book);

    //新增
    void bookInsert(Book book);

    //修改
    int bookUpdate(Book book);

    //按照ID进行删除
    int bookDelete(@Param("id") int id);

    //    按照Id进行查询 1 to n
    List<Book> bookAndAtour(@Param("id") Integer id);

    // 按照Id进行查询n to 1
    List<Author> AtourId(@Param("id") Integer id);
}
