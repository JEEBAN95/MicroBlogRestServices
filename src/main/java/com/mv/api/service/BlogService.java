package com.mv.api.service;

import java.util.List;

import com.mv.api.entity.Blog;

/**
 * Interface having methods related to {@link Blog}.
 * 
 * @author Jeeban
 */
public interface BlogService {

	public String saveBlog(Blog blog, String email);

	public String updateBlog(String blogName, Blog blog);
	
	public List<Blog> getBlogs(String email);
}
