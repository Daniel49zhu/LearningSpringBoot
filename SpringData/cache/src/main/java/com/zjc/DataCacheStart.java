package com.zjc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DataCacheStart {

    public static void main(String[] args) {
        SpringApplication.run(DataCacheStart.class,args);
    }
}
