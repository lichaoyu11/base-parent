package com.lcy.base.common.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cglib.beans.BeanMap;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description bean工具类
 * @Author lcy
 * @Date 2021/7/8 10:52
 */
@Slf4j
public class BeanUtil {

    /**
     * bean转map
     * @param bean bean
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author lcy
     * @date 2021/7/8 10:53
     **/
    public static <T> Map<String,Object> beanToMap(T bean){
        Map<String,Object> map = new HashMap<>();
        if (bean != null) {
            BeanMap beanMap = BeanMap.create(bean);
            for (Object key : beanMap.keySet()) {
                if (beanMap.get(key) != null) {
                    map.put(String.valueOf(key),beanMap.get(key));
                }
            }
        }
        return map;
    }

    /**
     * map转bean
     * @param map      map
     * @param beanType bean类型
     * @return T
     * @author lcy
     * @date 2021/7/8 10:53
     **/
    public static <T> T mapToBean(Map<String,Object> map,Class<T> beanType){
        T t = null;
        try {
            t = beanType.getDeclaredConstructor().newInstance();
            BeanUtils.populate(t,map);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            log.error("map to bean error。beanType = {},map = {}",beanType,map,e);
        }
        return t;
    }

    /**
     * 复制对象信息
     * @param source 源对象
     * @param target 目标对象
     * @author lcy
     * @date 2021/7/8 11:01
     **/
    public static void copyBean(Object source,Object target){
        org.springframework.beans.BeanUtils.copyProperties(source,target);
    }

}
