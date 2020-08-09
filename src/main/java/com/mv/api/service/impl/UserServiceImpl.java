package com.mv.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.api.entity.User;
import com.mv.api.repository.UserRepository;
import com.mv.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
		LOGGER.info("Dependancy injection is done of :" + UserRepository.class);
		
	}

	/**
	 * This method takes user instance as method param persists {@link User} data by
	 * invoking repository. {@link UserRepository}
	 * 
	 * @param user -{@link User} instance
	 * @return user -{@link User} instance.
	 */
	@Override
	public User registerUser(User user) {

		LOGGER.info("BlogServiceImpl#registerUser method execution is started..");
		User newUser = null;
		if (!user.equals(null))
			newUser = userRepository.save(user);
		return newUser;
	}		
}
