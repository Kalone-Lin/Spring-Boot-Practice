package com.kalone.mylog.security.controller;

import com.kalone.mylog.security.dto.User;
import com.kalone.mylog.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * description
 *
 * @author shelin 2021/02/25 16:16
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/queryuser")
    public List<User> getLogin() {
        return userService.queryUserList();
    }

    @PostMapping("/createuser")
    public User getLogin(@RequestBody User user) {
        return userService.createUser(user);
    }

}
