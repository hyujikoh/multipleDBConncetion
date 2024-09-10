package com.hyujikoh.multipledbconnection.domain.user.service;

import com.hyujikoh.multipledbconnection.config.DataSourceConfig;
import com.hyujikoh.multipledbconnection.domain.user.entity.User;
import com.hyujikoh.multipledbconnection.domain.user.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Service;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */
@Service
@RequiredArgsConstructor
public class UserService {
	private final DataSourceConfig dataSourceConfig;
	private final UserRepository userRepository;

		public List<User> findAll(String factoryCode){
			dataSourceConfig.setDataSource(factoryCode);
				return userRepository.findAll();
		}
}
