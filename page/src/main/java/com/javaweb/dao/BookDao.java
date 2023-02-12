package com.javaweb.dao;

import com.javaweb.pojo.Book_Info;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:
 */
public interface BookDao {
    
    /**
     * 查询总记录数
     *
     * @return
     *
     * @throws SQLException
     */
    Integer queryPageTotalCount() throws SQLException;
    
    /**
     * 查询当前页数据
     *
     * @param begin
     * @param pageSize
     * @return
     *
     * @throws SQLException
     */
    List<Book_Info> queryPageItems(int begin, Integer pageSize) throws SQLException;
    
    /**
     * 根据价格区间计算总页数
     *
     * @param min
     * @param max
     * @return
     */
    Integer queryPageTotalCountByPrice(Integer min, Integer max) throws SQLException;
    
    /**
     * 查询根据价格区间区分的当前页数据并按价格进行升序排列
     *
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     *
     * @throws SQLException
     */
    List<Book_Info> queryPageItemsByPrice(int begin, Integer pageSize, Integer min, Integer max) throws SQLException;
}