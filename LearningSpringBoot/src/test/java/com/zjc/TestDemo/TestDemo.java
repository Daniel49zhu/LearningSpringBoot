package com.zjc.TestDemo;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestDemo {
    @Test
    public void testConvert() throws Exception{
        Map<String, Object> map = new HashMap<String, Object>() {{
            this.put("ID", "d806ec2e3160451396f0cf934d9cea85");
            this.put("AJMC", "NULL");
            this.put("AFDD", "安徽省芜湖市镜湖区xx小区");
            this.put("FASJKS", "2018-12-21");
            this.put("FASJJS", "2018/12/31 03:23:32");
            this.put("XCKYH", "3aed4c601a144e3e94cfad8bb86bef87");
            this.put("SARY", "王阳，胡无数");
            this.put("LADW_ID", "1123");
            this.put("LADWMC", "镜湖区交警大队");
            this.put("AJFZR_ID", "2352");
            this.put("AJFZRXM", "汪洋，木湖是");
            this.put("AJXQ", "哈哈啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊");
            this.put("AJFXGC", "啊哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
            this.put("XGR_ID", "5312");
            this.put("CJR_ID", "23");
            this.put("XQPCSID", "1323");
            this.put("AJBH", "85d39428a7c54186829e64bb13af0eac");
            this.put("JJH", "01c8e76c6c6e42d1b44cef772d6f4a7a");
        }};
        Gaaj gaaj = new Gaaj();
        MyBeanUtil.addDatePattern("yyyy/MM/dd hh:mm:ss");
        MyBeanUtil.convert(gaaj,map);
        System.out.println(gaaj);
    }

    @Test
    public void generateUUID() {
        System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));
    }

    @Test
    public void generateDate() {
        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void match() {
        String[] patterns = {"yyyy-MM-dd","yyyy-MM-dd hh:mm:ss"};
        String date = "2018-12-31 03:23:32";
        for(String pattern :patterns) {
            if(pattern.trim().length()==date.trim().length()) {
                SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
                try{
                    dateFormat.parse(date);
                } catch (Exception e) {
                    continue;
                }
            }
        }
    }

}
