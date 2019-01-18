package com.zjc.service;

import com.zjc.domain.Person;

public interface DemoService {

    /**
     * 新增
     * @param person
     * @return
     */
    Person save(Person person);

    /**
     * 移除
     * @param id
     */
    void remove(Long id);

    /**
     * 查询
     * @param person
     * @return
     */
    Person findOne(Person person);
}
