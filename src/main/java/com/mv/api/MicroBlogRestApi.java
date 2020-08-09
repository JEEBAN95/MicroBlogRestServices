package com.mv.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroBlogRestApi {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(MicroBlogRestApi.class);

	public static void main(String[] args) {
		LOGGER.info("MicroBlogsRestApi execution has been started...");
		SpringApplication.run(MicroBlogRestApi.class, args);
	}
}
