package com.javaweb.service.Impl;

import com.javaweb.dao.BookDao;
import com.javaweb.dao.impl.BookDaoImpl;
import com.javaweb.pojo.Book_Info;
import com.javaweb.pojo.Page;
import com.javaweb.service.BookService;

import java.sql.SQLException;
import java.util.List;

/**
 * {@code @Description:}
 */
public class BookServiceImpl implements BookService {
    
    private BookDao bookDao = new BookDaoImpl();
    
    
    /**
     * 处理分页功能
     *
     * @param pageNo
     * @return
     *
     * @throws SQLException
     */
    @Override
    public Page<Book_Info> page(Integer pageNo) throws SQLException {
        
        Page<Book_Info> page = new Page<>();
        
        // 设置每页显示数量
        // 不需要，因为常量已经设置
        
        // 求总记录数并设置
        Integer pageTotalCount = bookDao.queryPageTotalCount();
        page.setPageTotalCount(pageTotalCount);
        
        // 求总页码数并设置
        Integer pageTotal;
        pageTotal = pageTotalCount % Page.PAGE_SIZE > 0 ? (pageTotalCount / Page.PAGE_SIZE + 1) : (pageTotalCount / Page.PAGE_SIZE);
        page.setPageTotal(pageTotal);
        
        // 设置当前页码
        // setPageNo() 方法内当前页码需要和总页码数进行比较，所以放在后面
        page.setPageNo(pageNo);
        
        // 查询当前页数据并设置
        // 求当前页的开始索引，注意 page.getPageNo()
        int begin = (page.getPageNo() - 1) * Page.PAGE_SIZE;
        List<Book_Info> items = bookDao.queryPageItems(begin, Page.PAGE_SIZE);
        page.setItems(items);
        
        // 设置跳转链接
        page.setUrl("PageServlet?");
        
        return page;
    }
    
    
    /**
     * 根据价格区间并按升序排列分页显示数据
     *
     * @param pageNo
     * @param min
     * @param max
     * @return
     */
    @Override
    public Page<Book_Info> pageByPrice(Integer pageNo, Integer min, Integer max) throws SQLException {
        
        // 求价格区间内的总记录数并设置
        Integer pageTotalCount = bookDao.queryPageTotalCountByPrice(min, max);
        
        if (pageTotalCount == 0) {  // 因为存在没有想要的价格区间的情况，即查找不出记录，则执行 page(pageNo) 返回查询所有分页数据或设置 page 的 url，让控制层判断

           /* //求总记录数并设置
            pageTotalCount = bookDao.queryPageTotalCount();
            page.setPageTotalCount(pageTotalCount);

            //求总页码数并设置
            Integer pageTotal;
            pageTotal = pageTotalCount % Page.PAGE_SIZE > 0 ? (pageTotalCount / Page.PAGE_SIZE + 1) : (pageTotalCount / Page.PAGE_SIZE);
            page.setPageTotal(pageTotal);

            //设置当前页码
            // setPageNo() 方法内当前页码需要和总页码数进行比较，所以放在后面
            page.setPageNo(pageNo);

            //查询当前页数据并设置
            //求当前页的开始索引，注意 page.getPageNo()
            int begin = (page.getPageNo() - 1) * Page.PAGE_SIZE;
            List<Book_Info> items = bookDao.queryPageItems(begin, Page.PAGE_SIZE);
            page.setItems(items);

            //设置跳转链接
            page.setUrl("PageServlet?");

            return page;*/
            
            
            
            /*return page(pageNo);*/
            
            
            Page<Book_Info> page = new Page<>();
            // 设置跳转链接
            page.setUrl("PageServlet?");
            /*也可以直接设置 page.setPageTotalCount(pageTotalCount);
             * 让控制层判断是否 page.getPageTotalCount()==null
             * 是则重新跳转到 PageServlety 重新查询所有分页信息
             * */
            return page;
            
            
        } else { // 如果存在有想要查找的价格区间的情况，即可以查找出记录
            
            Page<Book_Info> page = new Page<>();
            
            // 设置每页显示数量
            // 不需要，因为常量已经设置
            
            page.setPageTotalCount(pageTotalCount);
            
            // 求总页码数并设置
            Integer pageTotal;
            pageTotal = pageTotalCount % Page.PAGE_SIZE > 0 ? (pageTotalCount / Page.PAGE_SIZE + 1) : (pageTotalCount / Page.PAGE_SIZE);
            page.setPageTotal(pageTotal);
            
            // 设置当前页码
            // setPageNo() 方法内当前页码需要和总页码数进行比较，所以放在后面
            page.setPageNo(pageNo);
            
            // 查询当前页数据并设置
            // 求当前页的开始索引，注意 page.getPageNo()
            int begin = (page.getPageNo() - 1) * Page.PAGE_SIZE;
            List<Book_Info> items = bookDao.queryPageItemsByPrice(begin, Page.PAGE_SIZE, min, max);
            page.setItems(items);
            
            // 设置跳转链接
            page.setUrl("PageByPriceServlet?min=" + min + "&max=" + max + "&");
            
            
            return page;
        }
        
    }
}