package com.kalone.mylog.hellow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 接口测试
 *
 * @author shelin 2021/02/24 17:01
 */
@Controller
public class HellowSpringBoot {

    @RequestMapping("/hellow")
    @ResponseBody
    public String hello() {
        return "hellow spring boot!";
    }

    @GetMapping("/")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("newWorld","This is the starting point");
        return modelAndView;
    }

}
