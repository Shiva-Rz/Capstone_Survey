package com.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.post.entity.Post;
import com.post.entity.PostDTO;
import com.post.service.PostService;

@RestController
@CrossOrigin("http://localhost:4200/") 
public class PostController {
	
	@Autowired(required=true)
	PostService posts;
	
	@PostMapping("/postInsert")
	public String performInsert(@RequestBody PostDTO postDto) throws Exception {
		posts.addPost(postDto);
		return "post Inserted";
	}
	
	
	@PutMapping("/post")
	public String performUpdate(@RequestBody Post post) {
		posts.updatepost(post);
		return "post updated";
	}
	

	@GetMapping("/viewAllPost")
	public List<Post> getAllpost(){
           return posts.getAllPost();
		
	}
	
	@DeleteMapping("/post/{postId}")
	public void performDelete(@PathVariable("postId") long postId) {
		posts.deletepost(postId);
		System.out.println("Draft Deleted");
	}
	
	
	@GetMapping("/published")
	  public ResponseEntity<List<Post>> getPublishedPosts() {
	    List<Post> publishedPosts = posts.getPublishedPosts();
	    return ResponseEntity.ok(publishedPosts);
	  }

	  @GetMapping("/drafts")
	  public ResponseEntity<List<Post>> getDraftPosts() {
	    List<Post> draftPosts = posts.getDraftPosts();
	    return ResponseEntity.ok(draftPosts);
	  }
	  
	  @GetMapping("/postview/{postId}")
		public PostDTO performview(@PathVariable("postId") long postId) {
			return posts.viewpost(postId);
			
			
		}
	  
	  @GetMapping("/getpostregionuser/{userId}")
		public List<Post> viewSurveyRegionUser(@PathVariable("userId") long userId) {
			return posts.getSurveyRegionUser(userId);

		}
	  
}
//	@GetMapping("/viewAllPost")
//    public ResponseEntity<List<Map<String, Object>>> getAllPosts() {
//        List<Map<String, Object>> postOutput = posts.getAllPostOutput();
//        return ResponseEntity.ok(postOutput);
//    }
	
	
	
//	@GetMapping("/viewAll")
//	  public List<PostDTO> getPostsWithSpecificColumns() {
//	    return posts.getPostsWithSpecificColumns();
//	  }
//	}
	
//	public String getAllpost() {
//		return posts.getAllPost();
//	}
	
	

