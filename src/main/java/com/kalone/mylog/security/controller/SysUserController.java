package com.kalone.mylog.security.controller;

import com.kalone.mylog.security.dao.SysUserRepository;
import com.kalone.mylog.security.dto.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * description
 *
 * @author shelin 2021/02/25 16:16
 */
@RestController
@RequestMapping("/sysuser")
public class SysUserController {

    @Autowired
    private SysUserRepository sysUserRepository;

    @GetMapping("/queryuser")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<SysUser> getLogin() {
        return sysUserRepository.findAll();
    }

    @PostMapping("/createuser")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public SysUser getLogin(@RequestBody SysUser SysUser) {
        return sysUserRepository.save(SysUser);
    }

}
