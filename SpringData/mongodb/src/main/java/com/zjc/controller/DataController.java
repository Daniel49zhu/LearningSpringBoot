package com.zjc.controller;

import com.zjc.dao.PersonRepository;
import com.zjc.domain.Location;
import com.zjc.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository;

    /**
     * // 测试保存数据
     *
     * @return
     */
    @RequestMapping("/save")
    public Person save() {
        Person p = new Person("zc", 22);
        Collection<Location> locations = new LinkedHashSet<Location>();
        Location loc1 = new Location("重庆", "2017");
        Location loc2 = new Location("合川", "2016");
        Location loc3 = new Location("上海", "2015");
        Location loc4 = new Location("北京", "2014");
        locations.add(loc1);
        locations.add(loc2);
        locations.add(loc3);
        locations.add(loc4);
        p.setLocations(locations);
        return personRepository.save(p);
    }

    /**
     * // 测试方法名查询
     *
     * @param name
     * @return
     */
    @RequestMapping("/q1")
    public Person q1(String name) {
        return personRepository.findByName(name);
    }

    /**
     * // 测试@Query查询
     *
     * @param age
     * @return
     */
    @RequestMapping("/q2")
    public List<Person> q2(Integer age) {
        return personRepository.withQueryFindByAge(age);
    }

}
