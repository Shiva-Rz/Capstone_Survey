package com.post.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.post.entity.Department;
import com.post.entity.Post;
import com.post.entity.PostDTO;
import com.post.entity.Project;
import com.post.entity.Region;
import com.post.entity.User;
import com.post.repository.DepartmentRepo;
import com.post.repository.PostRepo;
import com.post.repository.ProjectRepo;
import com.post.repository.RegionRepo;
import com.post.repository.UserRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postrepo;

	@Autowired
	RegionRepo rgRepo;

	@Autowired
	Post post;

	@Autowired
	Region region;
	
	@Autowired
	Department department;

	@Autowired
	Project project;
	
	@Autowired
	DepartmentRepo dtRepo;

	@Autowired
	ProjectRepo ptRepo;
	
	@Autowired 
	User user;
	
	@Autowired
	UserRepo userRepo;
	

//	public boolean addPost(PostDTO postdto) {
//
//		post.setPostId(postrepo.count() + 1);
//		post.setPostContent(postdto.getPostContent());
//		post.setDateTime(postdto.getDateTime());
//		
//		region = rgRepo.findById(postdto.getRegion()).get();
//		post.setRegion(region);
//		
//		department = dtRepo.findById(postdto.getDepartment()).get();
//		post.setDepartment(department);
//		
//		project = ptRepo.findById(postdto.getProject()).get();
//		post.setProject(project);
//		
//		post.setStatus(true);
//		postrepo.save(post);
//		return true;
//	}
	
	
	public boolean addPost(PostDTO postdto) throws Exception {
		  Long nextPostId = postrepo.count()+ 1; 
		 
		  
		  if (postdto.getPostContent() == null || postdto.getPostContent().isEmpty()) {
		    throw new IllegalArgumentException("Post content cannot be null or empty");
		  }
		  
		 
		  Post post = new Post();
		  post.setPostId(nextPostId);
		  post.setPostContent(postdto.getPostContent());
		  post.setDateTime(postdto.getDateTime());
		  post.setStatus(postdto.isStatus());


		 
//		  // Handle region
		  Optional<Region> optionalRegion = rgRepo.findById(postdto.getRegion());
		  if (optionalRegion.isPresent()) {
		    post.setRegion(optionalRegion.get());
		  } else {
		    throw new Exception("Region with ID " + postdto.getRegion() + " not found");
		  }
		  
		 
		  Optional<Department> optionalDepartment = dtRepo.findById(postdto.getDepartment());
		  if (optionalDepartment.isPresent()) {
		    post.setDepartment(optionalDepartment.get());
		  } else {
		    throw new Exception("Department with ID " + postdto.getDepartment() + " not found");
		  }
		 
		
		  Optional<Project> optionalProject = ptRepo.findById(postdto.getProject());
		  if (optionalProject.isPresent()) {
		    post.setProject(optionalProject.get());
		  } else {
		    throw new Exception("Project with ID " + postdto.getProject() + " not found");
		  }
	
		  
		  Optional<User> optionalUser = userRepo.findById(postdto.getUser());
		  if (optionalUser.isPresent()) {
			    post.setUser(optionalUser.get());
			  } else {
				    throw new Exception("Region with ID " + postdto.getUser() + " not found");

			  }

		  postrepo.save(post);
		  return true;
		}
//
	public boolean updatepost(Post post) {
		postrepo.save(post);
		return true;
	}
	
	
	//new code as
	
//public boolean addPost(PostDTO postdto) {
//		
//	  Post post = new Post();
//	  post.setPostContent(postdto.getPostContent());
//	  post.setDateTime(postdto.getDateTime());
//	  post.setStatus(postdto.isStatus());
// 	
//		region = rgRepo.findById(postdto.getRegion()).get();
//		post.setRegion(region);
//		
//		department = dtRepo.findById(postdto.getDepartment()).get();
//		post.setDepartment(department);
//		
//		project = ptRepo.findById(postdto.getProject()).get();
//		post.setProject(project);
//		
//		user = userRepo.findById(postdto.getUser()).get();
//		post.setUser(user);
//		
//		postrepo.save(post);
//		return true;
//	}

	
	
	
	
	
	
	
	public boolean deletepost(long postId) {
		postrepo.deleteById(postId);
		return true;
	}
	

	public List<Post> getAllPost(){
		Iterator<Post> it = postrepo.findLatestPosts().iterator();
		ArrayList<Post> list = new ArrayList<>();
		
		while(it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
	
	public PostDTO viewpost(long postId) {
		Post post=postrepo.findById(postId).get();
		
		PostDTO postDto=new PostDTO();
		
		postDto.setPostContent(post.getPostContent());
		postDto.setPostId(post.getPostId());
		postDto.setDateTime(post.getDateTime());
		postDto.setStatus(post.isStatus());
		
		return postDto;
			
		}
	
	public List<Post> getPublishedPosts() {
	    List<Post> allPosts = postrepo.findAll();
	    return allPosts.stream()
	    		.filter(Post::isStatus) // Filter for published posts
                .sorted(Comparator.comparing(Post::getPostId).reversed()) // Sort by dateTime in reverse order
                .collect(Collectors.toList());
	  }
 
	  public List<Post> getDraftPosts() {
	    List<Post> allPosts = postrepo.findAll();
	    return allPosts.stream()
	                   .filter(post -> !post.isStatus()) // Filter by negation
	                   .sorted(Comparator.comparing(Post::getPostId).reversed())
	                   .collect(Collectors.toList());
	  }
	  
//		public List<PostDTO> getSurveyRegionUser(long userId) {
//			User user=userRepo.getByUserId(userId);
//			Region reg=user.getRegion();
////			Iterator<Post> it1 = postrepo.findByRegionUser(reg.getRegionId(),userId).iterator();
//			Iterator<Post> it1 = postrepo.findByRegion(reg.getRegionId()).iterator();
//		
//			ArrayList<PostDTO> postList = new ArrayList<>();
//			while (it1.hasNext()) {
//				Post post=it1.next();
//				PostDTO postDto=new PostDTO();
//				postDto.setPostId(post.getPostId());
//				postDto.setPostContent(post.getPostContent());
//				postDto.setDateTime(post.getDateTime());
//				postDto.setStatus(post.isStatus());
//				Region region = post.getRegion();
//				postDto.setRegion(region.getRegionId());
//				Department department = post.getDepartment();
//				postDto.setDepartment(department.getDepartmentId());
//				User users = post.getUser();
//				postDto.setUser(users.getUserId());
//				postList.add(postDto);
//			}
//			return postList;
//		}
	  
	  public List<Post> getSurveyRegionUser(long userId) {
			User user=userRepo.getByUserId(userId);
			Region reg=user.getRegion();
//			Iterator<Post> it1 = postrepo.findByRegionUser(reg.getRegionId(),userId).iterator();
			Iterator<Post> it1 = postrepo.findByRegion(reg.getRegionId()).iterator();
			ArrayList<Post> surveyList = new ArrayList<>();
			while (it1.hasNext()) {
				surveyList.add(it1.next());
			}
			return surveyList;
		}
	  
	  
	 // lastcode
//
//	  public List<Post> getSurveyDepartmentUser(long userId) {
//		    User user = userRepo.getByUserId(userId);
//		    Department department = user.getDepartment(); // Assuming User has a getDepartment() method
//
//		    // Using findByDepartmentId instead of findByRegionId
//		    Iterator<Post> it1 = postrepo.findByDepartmentId(department.getDepartmentId()).iterator();
//
//		    ArrayList<Post> surveyList = new ArrayList<>();
//		    while (it1.hasNext()) {
//		        surveyList.add(it1.next());
//		    }
//		    return surveyList;
//		}
	  
	  






	
		
	  

}

