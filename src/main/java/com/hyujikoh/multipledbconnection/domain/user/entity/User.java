package com.hyujikoh.multipledbconnection.domain.user.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */
@Entity
@Getter
public class User {
	@Id
	private Long id;
	private String name;

}
