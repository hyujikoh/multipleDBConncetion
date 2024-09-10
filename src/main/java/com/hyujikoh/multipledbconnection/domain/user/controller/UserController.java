package com.hyujikoh.multipledbconnection.domain.user.controller;

import com.hyujikoh.multipledbconnection.domain.user.entity.User;
import com.hyujikoh.multipledbconnection.domain.user.service.UserService;
import com.hyujikoh.multipledbconnection.domain.user.service.UserServiceImpl;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
		private final UserService userService;

		@GetMapping("/{factoryCode}")
		public List<User> getUserList(@PathVariable String factoryCode){
				return userService.findAll(factoryCode);
		}

}
