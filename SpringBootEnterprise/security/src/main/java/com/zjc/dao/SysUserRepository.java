package com.zjc.dao;

import com.zjc.domain.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser,Long> {

    /**
     * 根据名称查询用户
     * @param username
     * @return
     */
    SysUser findByUsername(String username);
}
