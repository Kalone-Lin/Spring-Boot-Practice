package com.kalone.mylog.security.dao;

import com.kalone.mylog.security.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * description
 *
 * @author shelin 2021/02/25 16:12
 */
public interface UserRepository extends JpaRepository<User, Long> {


}
