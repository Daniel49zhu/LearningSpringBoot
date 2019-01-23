package com.zjc.security;

import com.zjc.dao.SysUserRepository;
import com.zjc.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        // 我们当前的用户实现了UserDetails接口，可直接返回给SpringSecurity使用
        return user;
    }
}
