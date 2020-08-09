package com.mv.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.api.entity.User;
import com.mv.api.payload.Response;
import com.mv.api.service.UserService;

@RestController
@RequestMapping(value = "/user")
//@CrossOrigin(origins = "http://localhost:4200")
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
	public ResponseEntity<List<Response>> registerUserAndSaveBlog(@RequestBody User user) {
		
		User newUser = null;
		newUser = blogService.registerUser(user);
		if (newUser != null) {
			Response resp = new Response();
			resp.setUserEmail(newUser.getEmail());
			resp.setMessages("SUCCESS");
			List<Response> respList = new ArrayList<Response>();
			respList.add(resp);
			return ResponseEntity.ok().body(respList);
		}
		return ResponseEntity.badRequest().build();
	}
}
