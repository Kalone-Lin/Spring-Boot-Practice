package com.kalone.mylog.security.service.impl;

import com.kalone.mylog.security.dao.SysRoleRepository;
import com.kalone.mylog.security.dao.SysUserRepository;
import com.kalone.mylog.security.dao.SysUserRoleRepository;
import com.kalone.mylog.security.dto.SysRole;
import com.kalone.mylog.security.dto.SysUser;
import com.kalone.mylog.security.dto.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * description
 *
 * @author Kalone 2021/03/02 16:08
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private SysUserRepository userRepository;
    @Autowired
    private SysUserRoleRepository sysUserRoleRepository;
    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SysUser sysUser = userRepository.findByUsername(s);
        if (Objects.isNull(sysUser)) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        // 添加权限
        List<SysUserRole> userRoles = sysUserRoleRepository.findSysUserRoleByUserId(sysUser.getId());
        Iterator<SysUserRole> iterator = userRoles.iterator();
        while (iterator.hasNext()) {
            SysUserRole sysUserRole = iterator.next();
            Optional<SysRole> sysRole = sysRoleRepository.findById(sysUserRole.getRoleId());
            authorities.add(new SimpleGrantedAuthority(sysRole.get().getRoleName()));
        }
        return new User(sysUser.getUserName(),sysUser.getPassWord(),authorities);
    }
}
