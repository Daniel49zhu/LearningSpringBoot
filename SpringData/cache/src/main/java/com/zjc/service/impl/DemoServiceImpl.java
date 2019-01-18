package com.zjc.service.impl;

import com.zjc.dao.PersonRepository;
import com.zjc.domain.Person;
import com.zjc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private PersonRepository personRepository;

    /**
     * @CachePut缓存行的或更新的数据到缓存，其中缓存名称为people，数据的key是person的id。
     * @param person
     * @return
     */
    @CachePut(value="people",key="#person.id")
    public Person save(Person person) {
        Person p = personRepository.save(person);
        System.out.println("为id、key为："+p.getId()+" 数据做了缓存");
        return p;
    }

    /**
     * @CacheEvict从缓冲people中删除key为id的数据
     * @param id
     */
    @CacheEvict(value="people")
    public void remove(Long id) {
        System.out.println("删除了id、key为："+id+" 的数据缓存");
    }

    /**
     * @Cacheable缓存key为people的id数据缓存到people中
     * @param person
     * @return
     */
    @Cacheable(value="people",key="#person.id")
    public Person findOne(Person person) {
        Person p = personRepository.findOne(person.getId());
        System.out.println("为id、key为："+p.getId()+" 数据做了缓存");
        return p;
    }
}
