package com.kalone.mylog.security.service;

import com.kalone.mylog.security.dto.User;

import java.util.List;

/**
 * description
 *
 * @author shelin 2021/02/25 16:02
 */
public interface UserService {

    /**
     * 查询全部用户
     *
     * @param
     * @author shelin 2021-02-25 16:04
     * @return
     */
    List<User> queryUserList();

    /**
     * 创建用户
     *
     * @param
     * @author shelin 2021-02-25 16:04
     * @return
     */
    User createUser(User user);
}
