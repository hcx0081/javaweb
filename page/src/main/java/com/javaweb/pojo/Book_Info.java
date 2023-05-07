package com.javaweb.pojo;

import lombok.Data;

/**
 * {@code @Description:} 书本表
 */
@Data
public class Book_Info {
    // 书本编号
    private String bookid;
    // 书本名称
    private String bookname;
    // 书籍作者
    private String bookautor;
    // 书籍价格
    private double bookprice;
    // 书籍库存
    private int booknum;
}