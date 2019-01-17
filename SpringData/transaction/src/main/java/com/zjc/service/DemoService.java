package com.zjc.service;

import com.zjc.domain.Person;

public interface DemoService {

    /**
     * 保存信息，当名称重复时保存失败并回滚
     * @param person
     * @return
     */
    Person savePersonWithRollBack(Person person);

    /**
     * 保存信息，当名称重复时保存成功并不回滚
     * @param person
     * @return
     */
    Person savePersonWithoutRollBack(Person person);
}
