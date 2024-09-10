package com.hyujikoh.multipledbconnection.domain.user.service;

import com.hyujikoh.multipledbconnection.domain.user.entity.User;

import java.util.List;

/**
 * @author hyunjikoh
 * @since 2024-09-10
 */
public interface UserService {
    List<User> findAll(String factoryCode);
}
