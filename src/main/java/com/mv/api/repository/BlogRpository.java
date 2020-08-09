package com.mv.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mv.api.entity.Blog;
import java.lang.String;
import com.mv.api.entity.User;
import java.util.List;

/**
 * @author Jeeban
*/
@Repository
public interface BlogRpository extends JpaRepository<Blog, Integer> {

	public Blog findByBlogName(String blogname);
	
	public  List<Blog> findByUser(User user);
}
