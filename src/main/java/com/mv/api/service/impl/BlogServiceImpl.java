package com.mv.api.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mv.api.entity.Blog;
import com.mv.api.entity.User;
import com.mv.api.exception.ResourseNotAvailableException;
import com.mv.api.repository.BlogRpository;
import com.mv.api.repository.UserRepository;
import com.mv.api.service.BlogService;

/**
 * @author Jeeban
 */
@Service
public class BlogServiceImpl implements BlogService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BlogServiceImpl.class);

	private BlogRpository blogRepository;

	@Autowired
	private UserRepository userRepository;

	public final Path storagePath;

	@Autowired
	public BlogServiceImpl(BlogRpository blogRepository) {
		this.blogRepository = blogRepository;
		storagePath = Paths.get("/blogFiles/").toAbsolutePath().normalize();
	}

	/**
	 * This method takes blog instance as method param persists blog details data by
	 * invoking repository. {@link UserRepository}
	 * 
	 * @param blog -{@link Blog} instance
	 * @return user -{@link User} instance.
	 */
	@Override
	public String saveBlog(Blog blog, String email) {

		LOGGER.info("BlogServiceImpl#saveBlog method execution started..");
		User user = null;
		String fileName = blog.getBlogName() + ".txt";
		Blog newBlog = null;
		try {
			LOGGER.info("try() block execution started..");
			Files.createDirectories(storagePath);
			File newFile = new File(storagePath.toString() + "/" + fileName);

			if (!newFile.exists()) {
				newFile.createNewFile();
				Path path = Files.write(newFile.toPath(), blog.getText().getBytes());
				newBlog = new Blog();
				newBlog.setBlogName(blog.getBlogName());
				byte[] blogContent = readfile(path);
				newBlog.setBlogContents(blogContent);
				user = userRepository.findByEmail(email);
				newBlog.setUser(user);
				blogRepository.save(newBlog);

			}
			return "SUCCESSFUL";
		} catch (IOException e) {
			LOGGER.error("Exception rised at catch block");
			throw new ResourseNotAvailableException(storagePath.toString() + " path is not available..", e);
		}
	}

	/**
	 * This method updates the blog.
	 * 
	 * @param blogName
	 */
	@Override
	public String updateBlog(String blogName, Blog updblog) {

		Blog blog = blogRepository.findByBlogName(blogName);
		String updcontents = updblog.getText();
		String fileName = blog.getBlogName() + ".txt";
		try {
			Files.createDirectories(storagePath);
			File newFile = new File(storagePath.toString() + "/" + fileName);

			if (newFile.exists()) {
				newFile.createNewFile();
				Path path = Files.write(newFile.toPath(), updcontents.getBytes());
				byte[] blogContent = readfile(path);
				blog.setBlogContents(blogContent);
				blogRepository.save(blog);
			}
		} catch (IOException e) {
			LOGGER.error("Exception rised at catch block");
			throw new ResourseNotAvailableException(storagePath.toString() + " path is not available..", e);
		}
		return null;
	}

	/**
	 * 
	*/
	@Override
	public List<Blog> getBlogs(String email) {

		User user = userRepository.findByEmail(email);
		System.out.println(user);
		List<Blog> blog = blogRepository.findByUser(user);
		System.out.println(blog);
		return blog;
	}

	/**
	 * This method useed to read the file and write the blob to database
	 */
	private byte[] readfile(Path path) {

		byte[] blogContent = null;
		try {
			blogContent = Files.readAllBytes(path);
			return blogContent;
		} catch (IOException e) {
			LOGGER.error("Exception rised at catch block");
			throw new ResourseNotAvailableException(storagePath.toString() + " path is not available..", e);
		}
	}
}
