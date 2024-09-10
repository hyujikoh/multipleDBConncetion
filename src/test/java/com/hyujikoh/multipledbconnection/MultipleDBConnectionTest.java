package com.hyujikoh.multipledbconnection;

import com.hyujikoh.multipledbconnection.domain.user.entity.User;
import com.hyujikoh.multipledbconnection.domain.user.service.UserService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author hyunjikoh
 * @since 2024-07-08
 */

@SpringBootTest
@AutoConfigureMockMvc
public class MultipleDBConnectionTest {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserService userService;

	public MultipleDBConnectionTest(
		UserService userService) {
		this.userService = userService;
	}

	@Test
	    void contextLoads() {
	}

	@Test
	public void isActive(){
		String factoryCode = "factoryb";
		List<User> userList = userService.findAll(factoryCode);
	}
}
