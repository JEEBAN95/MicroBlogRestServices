package com.mv.api.service;

import com.mv.api.entity.User;
import com.mv.api.service.impl.UserServiceImpl;

/**
 * Interface having methods related to {@link User}.
 * 
 * @see UserServiceImpl
 * 
 * @author Jeeban
 */
public interface UserService {

	public User registerUser(User user);

}
