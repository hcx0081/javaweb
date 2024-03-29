package com.javaweb.service;

import com.javaweb.entity.Book_Info;
import com.javaweb.entity.Page;

import java.sql.SQLException;

/**
 * {@code @description:}
 */
public interface BookService {
    /**
     * 处理分页功能
     *
     * @param pageNo
     * @return
     * @throws SQLException
     */
    Page<Book_Info> page(Integer pageNo) throws SQLException;

    /**
     * 价格区间搜索按升序排列并分页
     *
     * @param pageNo
     * @param min
     * @param max
     * @return
     * @throws SQLException
     */
    Page<Book_Info> pageByPrice(Integer pageNo, Integer min, Integer max) throws SQLException;
}