package com.kalone.mylog.security.dao;

import com.kalone.mylog.security.dto.User;
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
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "insert into user_info(username,password,role) values(?,?,?)", nativeQuery = true)
    @Transactional
    @Modifying
    int createUser(@Param("user") User user);

}
