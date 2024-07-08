package com.hyujikoh.multipledbconnection.domain.user.repository;

import com.hyujikoh.multipledbconnection.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */
public interface UserRepository extends JpaRepository<User,Long> {

}
