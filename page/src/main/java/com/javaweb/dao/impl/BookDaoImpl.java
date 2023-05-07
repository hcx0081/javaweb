package com.javaweb.dao.impl;

import com.javaweb.dao.BookDao;
import com.javaweb.pojo.Book_Info;
import com.javaweb.utils.DataSourceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * {@code @Description:}
 */
public class BookDaoImpl implements BookDao {
    /**
     * 查询总记录数
     *
     * @return
     *
     * @throws SQLException
     */
    @Override
    public Integer queryPageTotalCount() throws SQLException {
        String sql = "select count(*) from book_info";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return ((Number) runner.query(sql, new ScalarHandler<>())).intValue();
    }
    
    /**
     * 查询当前页数据
     *
     * @param begin
     * @param pageSize
     * @return
     */
    @Override
    public List<Book_Info> queryPageItems(int begin, Integer pageSize) throws SQLException {
        String sql = "select * from book_info limit ?,?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Book_Info>(Book_Info.class), begin, pageSize);
    }
    
    /**
     * 根据价格区间计算总页数
     *
     * @param min
     * @param max
     * @return
     */
    @Override
    public Integer queryPageTotalCountByPrice(Integer min, Integer max) throws SQLException {
        String sql = "select count(*) from book_info where bookprice between ? and ?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return ((Number) runner.query(sql, new ScalarHandler<>(), min, max)).intValue();
    }
    
    /**
     * 查询根据价格区间区分的当前页数据并按价格进行升序排列
     *
     * @param begin
     * @param pageSize
     * @param min
     * @param max
     * @return
     */
    @Override
    public List<Book_Info> queryPageItemsByPrice(int begin, Integer pageSize, Integer min, Integer max) throws SQLException {
        String sql = "select * from book_info where bookprice between ? and ? order by bookprice limit ?,?";
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        return runner.query(sql, new BeanListHandler<Book_Info>(Book_Info.class), min, max, begin, pageSize);
    }
}