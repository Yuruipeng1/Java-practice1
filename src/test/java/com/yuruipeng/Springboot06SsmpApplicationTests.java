package com.yuruipeng;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yuruipeng.dao.BookDao;
import com.yuruipeng.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot06SsmpApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        System.out.println(bookDao.selectById(1));
    }

    @Test
    void testSave() {
        Book book=new Book();
        book.setType("测试数据123");
        book.setName("测试数据123");
        book.setDescription("测试数据123");
        bookDao.insert(book);
    }

    @Test
    void testUpdate() {
        Book book=new Book();
        book.setId(12);
        book.setType("测试数据1adf");
        book.setName("测试数据123dfd");
        book.setDescription("测试数据123asf");
        bookDao.updateById(book);

    }

    @Test
    void testDelete() {
        bookDao.deleteById(12);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null).forEach(book -> {
            System.out.println(book);
        });
    }

    @Test
    void testGetPage() {
        IPage page=new Page(2,5);
        bookDao.selectPage(page,null);
//        System.out.println(page.getRecords());
//        System.out.println(page.getSize());
    }

    @Test
    void testGetBy(){
        //按条件查询
        QueryWrapper<Book> qw=new QueryWrapper<>();
        qw.like("name","Spring");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        //按条件查询
        String name="Spring";
        LambdaQueryWrapper<Book> lqw=new LambdaQueryWrapper<>();
//        if(name!=null) {
//            lqw.like(Book::getName, name);
//        }
        lqw.like(name!=null,Book::getName,name);
        bookDao.selectList(lqw);
    }


}
