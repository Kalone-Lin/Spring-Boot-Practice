package com.kalone.mylog.security.dao;

import com.kalone.mylog.security.dto.SysUser;
import com.kalone.mylog.security.dto.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * description
 *
 * @author Kalone 2021/03/02 17:15
 */
public interface SysUserRoleRepository extends JpaRepository<SysUserRole, Long> {

    @Query(value = "select id,userid,roleid from sys_user_role where userid=:userId", nativeQuery = true)
    List<SysUserRole> findSysUserRoleByUserId(Long userId);

}
