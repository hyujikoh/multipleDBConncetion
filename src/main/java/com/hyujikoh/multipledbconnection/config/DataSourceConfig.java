package com.hyujikoh.multipledbconnection.config;

import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */

@Configuration
public class DataSourceConfig {
	@Value("${mysql.host}")
	private String host;

	@Value("${mysql.port}")
	private int port;

	@Value("${mysql.username}")
	private String username;

	@Value("${mysql.password}")
	private String password;

	@Value("${mysql.driver-class-name}")
	private String driverClassName;

	@Value("${mysql.dialect}")
	private String dialect;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		// 기본 URL은 호스트와 포트까지만 설정하고 DB 이름은 나중에 추가합니다.
		dataSource.setUrl(host);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	// 기본 EntityManagerFactory 설정
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.hyujikoh.multipledbconnection"); // 엔티티 클래스들이 위치한 패키지
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		return new JpaTransactionManager(entityManagerFactory);
	}

	// 동적으로 데이터베이스를 선택하여 EntityManager를 생성
	public EntityManagerFactory entityManagerFactoryForDatabase(String databaseName) {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		// 기본 URL은 호스트와 포트까지만 설정하고 DB 이름은 나중에 추가합니다.
		dataSource.setUrl(host + databaseName);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		em.setPackagesToScan("com.hyujikoh.multipledbconnection.domain.*"); // 엔티티 클래스들이 위치한 패키지
		em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		// Hibernate Dialect 설정
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.dialect", dialect);
		em.setJpaPropertyMap(properties);

		em.afterPropertiesSet(); // 필수로 설정

		return em.getObject();
	}
}
