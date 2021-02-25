package com.kalone.mylog.security.controller;

import com.kalone.mylog.security.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

/**
 * 登陆验证
 *
 * @author shelin 2021/02/24 18:29
 */
@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView getLogin(ModelAndView modelAndView) {
        modelAndView.setViewName("/login/login");
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView postLogin(ModelAndView modelAndView, User user) {
        if (StringUtils.isEmpty(user.getUserName())) {
            modelAndView.addObject("errormsg","账号不能为空");
            return modelAndView;
        }
        if (StringUtils.isEmpty(user.getPassWord())) {
            modelAndView.addObject("errormsg","密码不能为空");
            return modelAndView;
        }
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
