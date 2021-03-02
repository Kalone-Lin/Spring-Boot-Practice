package com.kalone.mylog.security.dto;

import javax.persistence.*;

/**
 * description
 *
 * @author Kalone 2021/03/02 16:57
 */
@Entity
@Table(name = "sys_role")
public class SysRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="rolename")
    private String roleName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
