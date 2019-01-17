package com.zjc.service.impl;

import com.zjc.dao.PersonRepository;
import com.zjc.domain.Person;
import com.zjc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DemoServiceImpl implements DemoService {

    public static final String TEST_NAME = "佟丽娅";

    @Autowired
    private PersonRepository personRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);

        if(TEST_NAME.equals(person.getName())){
            // 硬编码手动触发异常
            throw new IllegalArgumentException("佟丽娅已存在，数据将回滚");
        }

        return p;
    }

    @Transactional(noRollbackFor = {IllegalArgumentException.class},rollbackFor = {Error.class})
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        if(TEST_NAME.equals(person.getName())){
            throw new IllegalArgumentException("佟丽娅已存在，数据将不会回滚");
        }
        return p;
    }
}
