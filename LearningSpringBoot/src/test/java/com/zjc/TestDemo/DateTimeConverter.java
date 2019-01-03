package com.zjc.TestDemo;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class DateTimeConverter implements Converter {
    private static List<String> DATE_PATTERNS;

    public DateTimeConverter(List<String> patterns) {
        this.DATE_PATTERNS = patterns;
    }

    @Override
    public Object convert(Class type, Object value) {
        SimpleDateFormat simpleDateFormat = match(value.toString());
        try {
            return simpleDateFormat.parse(value.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    private SimpleDateFormat match(String date) {
        for(String pattern :DATE_PATTERNS) {
            if(pattern.trim().length()==date.trim().length()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                try{
                    dateFormat.parse(date);
                    return dateFormat;
                } catch (Exception e) {
                    continue;
                }
            }
        }
        return new SimpleDateFormat(DATE_PATTERNS.get(0));
    }
}