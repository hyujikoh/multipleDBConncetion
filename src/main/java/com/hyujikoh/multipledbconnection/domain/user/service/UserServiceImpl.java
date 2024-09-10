package com.hyujikoh.multipledbconnection.domain.user.service;

import com.hyujikoh.multipledbconnection.domain.user.entity.User;
import com.hyujikoh.multipledbconnection.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

		public List<User> findAll(String factoryCode){
				return userRepository.findAll();
		}
}
