package com.javaweb.pojo;

/**
 * @description: 书本表
 */
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
    
    public Book_Info() {
    }
    
    public String getBookid() {
        return bookid;
    }
    
    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    
    public String getBookname() {
        return bookname;
    }
    
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    
    public String getBookautor() {
        return bookautor;
    }
    
    public void setBookautor(String bookautor) {
        this.bookautor = bookautor;
    }
    
    public double getBookprice() {
        return bookprice;
    }
    
    public void setBookprice(double bookprice) {
        this.bookprice = bookprice;
    }
    
    public int getBooknum() {
        return booknum;
    }
    
    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }
    
    @Override
    public String toString() {
        return "Book{" +
                "bookid='" + bookid + '\'' +
                ", bookname='" + bookname + '\'' +
                ", bookautor='" + bookautor + '\'' +
                ", bookprice=" + bookprice +
                ", booknum=" + booknum +
                '}';
    }
}