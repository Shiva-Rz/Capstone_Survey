package com.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.post.service.PostService;

@SpringBootTest
class SbPostsApplicationTests {
	
	@Autowired
	PostService service;
	

	@Test
	void contextLoads() {
	}

}
