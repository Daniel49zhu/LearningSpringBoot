package com.zjc.dao;

import com.zjc.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person,Long> {
}