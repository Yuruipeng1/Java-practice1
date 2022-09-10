package com.yuruipeng.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yuruipeng.domain.Book;

public interface IBookService extends IService<Book> {

    IPage<Book> getPage(int currentPage, int pageSize, Book book);

    IPage<Book> getPage(int currentPage, int pageSize);

}
