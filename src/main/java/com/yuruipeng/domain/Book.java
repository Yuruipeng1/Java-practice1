package com.yuruipeng.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//指定实体类对应数据库的表名
@TableName("book")
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
