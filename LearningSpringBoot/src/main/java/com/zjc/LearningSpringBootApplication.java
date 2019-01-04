package com.zjc;

import com.zjc.LearningSpringBoot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class LearningSpringBootApplication {

    @Autowired
    private AuthorSettings authorSettings;

    //测试注入属性
    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    String index() {
//        return "hello spring boot,book author:"+bookAuthor + " and book name: "+bookName ;
        return "hello spring boot,book author:"+authorSettings.getName() + " and book name: "+authorSettings.getPrice() ;
    }

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringBootApplication.class, args);
	}

}

