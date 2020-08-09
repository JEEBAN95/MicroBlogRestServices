package com.mv.api;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.mv.api.entity.User;
import com.mv.api.repository.UserRepository;
import com.mv.api.service.impl.UserServiceImpl;

/**
 * Test class for testing the {@link UserServiceImpl} methods.
 */
//@SpringBootTest
public class BlogServiceTest {

	@InjectMocks
	private UserServiceImpl blogService;

	@Mock
	//@Autowired
	private UserRepository blogRepository;
	private static User user = new User();

	@BeforeEach
	public void init() {

		user.setUid(1);
		user.setUname("Alexa");
		user.setEmail("alexa@gmail.com");
		MockitoAnnotations.initMocks(this);
		blogService = new UserServiceImpl(blogRepository);
	}

	@Test
	public void test_RegisterUser1() {

		User newUser = blogService.registerUser(user);
		assertNotNull(newUser);
	}

	@Test
	public void test_RegisterUser2() {

		User user = null;
		User newUser = blogService.registerUser(user);
		assertNull(newUser);
//		fail(()->"Fail due to null value");
	}
}
