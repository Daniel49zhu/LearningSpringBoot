package com.zjc.controller;

import com.zjc.dao.PersonDao;
import com.zjc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController {

    @Autowired
    private PersonDao personDao;

    /**
     * // 演示设置字符及对象
     */
    @RequestMapping("/set")
    public void set(){
        Person person =new Person("1","zc",22);
        personDao.save(person);
        personDao.stringRedisTemplateDemo();
    }

    /**
     * // 演示获得字符
     * @return
     */
    @RequestMapping("/getString")
    public String getString(){
        return personDao.getString();
    }

    /**
     * // 演示获得对象
     * @return
     */
    @RequestMapping("/getPerson")
    public Person getPerson(){
        return personDao.getPerson();
    }
}
