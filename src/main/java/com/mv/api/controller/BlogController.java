package com.mv.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mv.api.entity.Blog;
import com.mv.api.payload.Response;
import com.mv.api.service.BlogService;

@RestController
@RequestMapping(value = "/blog")
//@CrossOrigin(origins = "http://localhost:4200")
public class BlogController {

	@Autowired
	private BlogService blogService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogController.class);

	/**
	 * This method takes blog details as argument.
	 * 
	 * @param blog {@link Blog} instance
	 * @return response {@link Response} instance
	 */
	@PostMapping(value = "/saveblog/{email}")
	public ResponseEntity<Response> submitBlog(@RequestBody Blog blog, @PathVariable("email") String email) {

		LOGGER.info("BlogController#submitBlog method execution started..");

		String msg = blogService.saveBlog(blog, email);
		Response resp = new Response();
		resp.setMessages(msg);
		return ResponseEntity.ok().body(resp);
	}

	/**
	*/
	@GetMapping(value = "/readblogs/{email}")
	public ResponseEntity<List<Blog>> showBlogFiles(@PathVariable("email") String email) {

		LOGGER.info("BlogController#showBlogFiles method execution started..");
		List<Blog> blogList = blogService.getBlogs(email);
		return ResponseEntity.ok(blogList);

	}

	/**
	 * This method takes blog details and blog name as argument for updating the
	 * blog content.
	 */
	@PostMapping(value = "/update/{blog_name}")
	public void updateBlog(@PathVariable("blog_name") String blogName, @RequestBody Blog blog) {

		LOGGER.info("BlogController#updateBlog method execution started..");
		blogService.updateBlog(blogName, blog);
	}

	/**
	 * This method takes blog details and blog name as argument for deleting the
	 * blog content.
	 */
	@PostMapping(value = "/delete/{email}/{blogName}")
	public void deleteBlog(@PathVariable("email") String email, @PathVariable("blogName") String blogName) {

		LOGGER.info("BlogController#updateBlog method execution started..");
		blogService.deleteBlog(email, blogName);
	}
}