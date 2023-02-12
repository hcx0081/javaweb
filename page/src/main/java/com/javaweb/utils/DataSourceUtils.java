package com.javaweb.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;

/**
 * @description: c3p0 数据池连接工具
 */
public class DataSourceUtils {
    
    // 无参数需要配置或直接调用默认 config
    private static DataSource dataSource = new ComboPooledDataSource();
    
    public static DataSource getDataSource() {
        return dataSource;
    }
}