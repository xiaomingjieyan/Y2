package com.xs;

import com.xs.dao.BookDao;
import com.xs.entity.Book;
import com.xs.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
    //查询所有图书
    @Test
    public void bookAll() {
        String resource = "mybatis-config.xml";
        // 2 通过mybatis的工具类加载这个文件为输入流
        InputStream in = null;
        SqlSessionFactory sessionFactory = null;
        SqlSession sqlSession = null;
        try {
            in = Resources.getResourceAsStream(resource);
            // 3 创建一个会话工厂  会话工厂的建造者（一次性用品）
            sessionFactory = new SqlSessionFactoryBuilder().build(in);
            // 4 利用工厂生产会话
            sqlSession = sessionFactory.openSession();
            // 5 使用会话进行相关的操作
            // 得到一个Mapper，mybatis本身通过动态代理帮我们去创建实例
            BookDao mapper = sqlSession.getMapper(BookDao.class);
            List<Book> books = mapper.bookList();
            System.out.println(books);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (sqlSession != null) {
            sqlSession.clearCache();
        }
    }

    @Test
    //查询所有图书
    public void booksAll() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        List<Book> list = mapper.bookList();
        System.out.println(list);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    //根据Id进行修改
    @Test
    public void update() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Book book = new Book();
        book.setId(1);
        book.setISBN("654613132");
        book.setName("asdf");
        book.setPrice(54);
        book.setDiscount(0.8);
        book.setPublisher("adsfdasfdsada");
        int row = mapper.bookUpdate(book);
        System.out.println("影响的行数:" + row);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    //根据Id进行删除
    @Test
    public void delete() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        int id = 1;
        int row = mapper.bookDelete(id);
        System.out.println("影响的行数:" + row);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    @Test
    //动态根据ID和Name进行查询
    public void booksIdAndName() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Book book = new Book();
        book.setId(115);
        book.setName("张三");
        List<Book> list = mapper.bookNameAndId(book);
        System.out.println(list);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }

    }

    //根据对象进行新增
    @Test
    public void insert() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Book book = new Book();
        book.setId(117);
        book.setISBN("65465132");
        book.setName("张三");
        book.setPrice(0.87);
        book.setDiscount(80);
        book.setPublisher("adsjfdsla");
        mapper.bookInsert(book);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.clearCache();
        }
    }

    //动态SQL修改
    @Test
    public void updateBook() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        Book book = new Book();
        book.setId(2);
        book.setISBN("654613132");
        book.setName("haha哈哈");
        book.setPrice(54);
        book.setDiscount(0.8);
        book.setPublisher("adsfdasfdsada");
        int row = mapper.bookUpdate(book);
        System.out.println("影响行数" + row);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

    //动态按照Id进行删除
    @Test
    public void deleteBookAsIdAndName() {
        SqlSession sqlSession = MybatisUtil.getSession();
        BookDao mapper = sqlSession.getMapper(BookDao.class);
        int result = 117;
        int row = mapper.bookDelete(result);
        System.out.println("影响的行数：" + row);
        sqlSession.commit();
        if (sqlSession != null) {
            sqlSession.close();
        }
    }
}
