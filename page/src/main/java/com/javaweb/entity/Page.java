package com.javaweb.entity;

import java.util.List;

/**
 * {@code @description:} 分页实体类
 */

/**
 * page 是分页的模型
 *
 * @param <E> 是具体的模块的 avaBean类，可以是book、shoes等
 */
public class Page<E> {
    public static final Integer PAGE_SIZE = 5;

    // 当前页码
    private Integer pageNo;
    // 总页数
    private Integer pageTotal;
    // 总记录数
    private Integer pageTotalCount;
    // 当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    // 当前页信息数据，注意是泛型，即是不确定的数据类型
    private List<E> items;

    // 分页跳转的链接
    private String url;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        /*
         * 数据边界的有效检查，防止直接在 地址栏 传参，即传页码，从而跳过JavaScript判断
         * 写在这里是因为每一次设置pageNo的值时都会进行判断，避免越界，即复用该代码
         * */
        if (pageNo < 1) {
            pageNo = 1;
        }
        if (pageNo > pageTotal) {
            pageNo = pageTotal;
        }

        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }


    public List<E> getItems() {
        return items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", pageTotalCount=" + pageTotalCount +
                ", pageSize=" + pageSize +
                ", items=" + items +
                ", url='" + url + '\'' +
                '}';
    }
}