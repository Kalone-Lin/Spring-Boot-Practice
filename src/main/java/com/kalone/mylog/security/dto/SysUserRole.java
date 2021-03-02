package com.kalone.mylog.security.dto;

import javax.persistence.*;

/**
 * description
 *
 * @author Kalone 2021/03/02 16:59
 */
@Entity
@Table(name = "sys_user_role")
public class SysUserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="userid")
    private Long userId;

    @Column(name="roleid")
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
