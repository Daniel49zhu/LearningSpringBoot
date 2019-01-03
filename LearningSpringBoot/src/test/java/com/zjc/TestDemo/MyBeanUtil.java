package com.zjc.TestDemo;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.*;

public class MyBeanUtil {
    private static final List<String> DATE_PATTERNS = new ArrayList<>();
    //提供了三个默认的日期处理格式(不要删)
    private static final String DEFAULT_PATTERN_1 = "yyyy-MM-dd";
    private static final String DEFAULT_PATTERN_2 = "yyyy-MM-dd hh:mm";
    private static final String DEFAULT_PATTERN_3 = "yyyy-MM-dd hh:mm:ss";

    public static void convert(Object bean, Map properties) throws Exception {
        addDefaultPattern();
        ConvertUtils.register(new DateTimeConverter(DATE_PATTERNS), Date.class);
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
        }
    }

    //手动添加的日期处理格式
    public static void addDatePattern(String... patterns) {
        DATE_PATTERNS.addAll(Arrays.asList(patterns));
    }

    //注册三个默认的日期处理格式
    private static void addDefaultPattern() {
        DATE_PATTERNS.add(DEFAULT_PATTERN_1);
        DATE_PATTERNS.add(DEFAULT_PATTERN_2);
        DATE_PATTERNS.add(DEFAULT_PATTERN_3);
        DuplicateRemoval(DATE_PATTERNS);
    }

    //利用set去重
    private static void DuplicateRemoval(List<String> ioList) {
        LinkedHashSet<String> tmpSet = new LinkedHashSet<>(ioList.size());
        tmpSet.addAll(ioList);
        ioList.clear();
        ioList.addAll(tmpSet);
    }

}
