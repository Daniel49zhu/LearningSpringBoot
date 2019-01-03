package com.zjc.TestDemo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class MyBeanUtil {

    public static void convert(Object bean, Map properties) throws Exception {
        ConvertUtils.register(new DateLocaleConverter(Locale.CHINA,"yyyy-MM-dd hh:MM:ss"),Date.class);
        Class clazz = bean.getClass();
        Field[] arr = clazz.getDeclaredFields();
        for (Field field : arr) {
            field.setAccessible(true);
            Column column = field.getAnnotation(Column.class);
            if (column == null) continue;
            String name = column.name();
            Object value = properties.get(name);
            if (value == null) continue;
            BeanUtils.setProperty(bean, field.getName(), value);
            System.out.println(properties.get(name));
        }
    }
}
