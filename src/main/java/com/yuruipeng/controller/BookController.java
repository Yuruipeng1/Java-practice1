package com.yuruipeng.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yuruipeng.controller.utils.R;
import com.yuruipeng.domain.Book;
import com.yuruipeng.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll(){
        return new R(true,bookService.list());
    }

    @PostMapping
    public R save(@RequestBody Book book) throws IOException {
        if(book.getName().equals("123")) throw new IOException();
        boolean flag = bookService.save(book);
        return new R(flag,flag?"添加成功":"添加失败");
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,bookService.getById(id));
    }

//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize){
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        //如果当前页码值大于总页码值,那么重新执行查询操作，使用最大页码值作为页码值
//        if(currentPage>page.getPages()){
//            page=bookService.getPage((int)page.getPages(),pageSize);
//        }
//        return new R(true,page);
//    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage,@PathVariable int pageSize,Book book){
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        //如果当前页码值大于总页码值,那么重新执行查询操作，使用最大页码值作为页码值
        if(currentPage>page.getPages()){
            page=bookService.getPage((int)page.getPages(),pageSize,book);
        }
        return new R(true,page);
    }
}
