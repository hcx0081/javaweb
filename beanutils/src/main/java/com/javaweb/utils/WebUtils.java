package com.javaweb.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @description: 工具类
 */
public class WebUtils {

    /**
     * 获取请求中的所有参数名和参数值封装到map集合中再封装到相应的JavaBean对象中
     * Dao层和Service层没有HttpServletRequest这个API，这样写耦合度高，不易于维护
     *
     * @param request
     * @param bean
     */
    public static void copyParamToBeanRes(HttpServletRequest request, Object bean) {

        try {
            BeanUtils.populate(bean, request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    /**
     * 将map集合的键值对信息封装到对应的JavaBean对象当中去
     * 这样写降低耦合，增强代码独立性
     *
     * @param paramValue
     * @param bean
     */
    public static <T> T copyParamToBean(Map paramValue, T bean) {

        try {
            BeanUtils.populate(bean, paramValue);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }


}
