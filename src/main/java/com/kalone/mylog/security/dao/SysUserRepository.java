package com.kalone.mylog.security.dao;

import com.kalone.mylog.security.dto.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * description
 *
 * @author shelin 2021/02/25 16:12
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    @Query(value = "select id,username,password from sys_user where username = :username", nativeQuery = true)
    SysUser findByUsername(@Param("username") String username);

}
