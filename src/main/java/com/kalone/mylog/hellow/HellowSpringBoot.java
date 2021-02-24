package com.kalone.mylog.hellow;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description
 *
 * @author shelin 2021/02/24 17:01
 */
@RestController
public class HellowSpringBoot {

    @RequestMapping("/hellow")
    public String hello() {
        return "hellow spring boot!";
    }

}
