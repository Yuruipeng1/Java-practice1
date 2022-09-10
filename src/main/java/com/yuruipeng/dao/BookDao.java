package com.yuruipeng.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yuruipeng.domain.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {
}
