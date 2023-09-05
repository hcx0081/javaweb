package com.javaweb.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * {@code @description:} 工具类
 */
public class WebUtils {
    
    /**
     * 获取请求中的所有参数名和其对应的所有参数值组成的Map集合并封装到相应的JavaBean对象中
     * Dao层和Service层没有HttpServletRequest这个对象，这样写耦合度高，不易于维护
     *
     * @param request
     * @param bean
     */
    public static void copyParamToBeanRes(HttpServletRequest request, Object bean) {
        try {
            BeanUtils.populate(bean, request.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * 将Map集合封装到相应的JavaBean对象中
     * 这样写耦合低，增强代码独立性
     *
     * @param paramValue
     * @param bean
     */
    public static <T> T copyParamToBean(Map<String, String[]> paramValue, T bean) {
        try {
            BeanUtils.populate(bean, paramValue);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}