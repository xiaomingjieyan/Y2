package com.xs;

import com.xs.dao.BookDao;
import com.xs.entity.Author;
import com.xs.entity.Book;
import com.xs.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class Test2 {
    //按照Id进行查询
    @Test
    public void m1() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        List<Book> list = mapper.bookAndAtour(1);
        System.out.println(list);
    }

    @Test
    public void m2()
    {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        List<Author> authors = mapper.AtourId(1);
        System.out.println(authors);
    }
}
