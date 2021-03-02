package com.kalone.mylog.security.service.impl;

import com.kalone.mylog.security.dao.SysUserRepository;
import com.kalone.mylog.security.dto.SysUser;
import com.kalone.mylog.security.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author shelin 2021/02/25 16:02
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserRepository userRepository;

}
