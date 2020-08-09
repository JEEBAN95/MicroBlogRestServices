package com.mv.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.api.entity.User;
import com.mv.api.payload.Response;
import com.mv.api.service.UserService;

@RestController
@RequestMapping(value = "/blog")
public class UserController {

	private UserService blogService;

	@Autowired
	public UserController(UserService blogService) {
		this.blogService = blogService;
	}

	/**
	 * This method takes the user details as argument as Json object, invokes
	 * {@link UserService#registerUser(User)}
	 * 
	 * @param user {@link User} instance
	 * @return response {@link Response} instance
	 */
	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = "application/json")
	public ResponseEntity<Response> registerUserAndSaveBlog(@RequestBody User user) {

		User newUser = null;
		newUser = blogService.registerUser(user);
		if (newUser != null) {
			Response resp = new Response();
			resp.setUserEmail(newUser.getEmail());
			resp.setUserName(newUser.getUname());
			resp.setMessages("SUCCESS");
			return ResponseEntity.ok().body(resp);
		}
		return ResponseEntity.badRequest().build();
	}

	
}
