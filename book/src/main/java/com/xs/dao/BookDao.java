package com.xs.dao;

import com.xs.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> bookList();

    void bookInsert(Book book);

    int bookUpdate(Book book);

    int bookDelete(int id);
}
