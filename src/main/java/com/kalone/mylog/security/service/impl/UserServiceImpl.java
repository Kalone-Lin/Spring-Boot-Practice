package com.kalone.mylog.security.service.impl;

import com.kalone.mylog.security.dao.UserRepository;
import com.kalone.mylog.security.dto.User;
import com.kalone.mylog.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description
 *
 * @author shelin 2021/02/25 16:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 查询全部用户
     *
     * @param
     * @author shelin 2021-02-25 16:04
     * @return
     */
    @Override
    public List<User> queryUserList() {
        return userRepository.findAll();
    }
}
